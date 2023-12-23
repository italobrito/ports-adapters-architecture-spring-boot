package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.ClienteRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;

@Component
public class ClienteMapper {
	
	@Autowired
	private EnderecoMapper enderecoMapper;
	
    public Cliente paraCliente(ClienteRequest clienteRequest) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteRequest.getNome());
        cliente.setCpfCnpj(clienteRequest.getCpfCnpj());
        cliente.setEnderecos(enderecoMapper.paraListaEndereco(clienteRequest.getEnderecos()));
        return cliente;
    }
    
    public List<Cliente> paraCliente(List<ClienteRequest> clienteRequests) {
        List<Cliente> clientes = new ArrayList<>();
        for (ClienteRequest clienteRequest : clienteRequests) {
            Cliente cliente = new Cliente();
            cliente.setId(clienteRequest.getId());
            cliente.setNome(clienteRequest.getNome());
            cliente.setCpfCnpj(clienteRequest.getCpfCnpj());
            if (clienteRequest.getEnderecos() != null) {
            	cliente.setEnderecos(enderecoMapper.paraListaEndereco(clienteRequest.getEnderecos()));
            }
            clientes.add(cliente);
        }
        return clientes;
    }
    
    public List<ClienteEntity> paraClienteEntity(List<ClienteRequest> clienteRequests) {
        List<ClienteEntity> clientesEntity = new ArrayList<>();
        for (ClienteRequest clienteRequest : clienteRequests) {
            ClienteEntity clienteEntity = new ClienteEntity();
            clienteEntity.setNome(clienteRequest.getNome());
            clienteEntity.setCpfCnpj(clienteRequest.getCpfCnpj());
            clienteEntity.setEnderecos(enderecoMapper.paraListaEnderecoEntity(clienteRequest.getEnderecos()));
            clientesEntity.add(clienteEntity);
        }
        return clientesEntity;
    }
    
}
