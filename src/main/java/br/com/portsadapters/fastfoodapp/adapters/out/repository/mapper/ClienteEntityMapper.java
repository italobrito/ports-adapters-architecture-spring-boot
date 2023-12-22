package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.core.domain.Endereco;

@Component
public class ClienteEntityMapper {
	
    public ClienteEntity paraClienteEntity(Cliente cliente) {
    	
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(cliente.getId());
        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setCpfCnpj(cliente.getCpf());

        List<EnderecoEntity> enderecosEntity = new ArrayList<>();
        
        if (cliente.getEnderecos() != null) {
            for (Endereco endereco : cliente.getEnderecos()) {
            	
                EnderecoEntity enderecoEntity = new EnderecoEntity();
                enderecoEntity.setRua(endereco.getRua());
                enderecoEntity.setCep(endereco.getCep());
                enderecoEntity.setNumero(endereco.getNumero());
                enderecoEntity.setComplemento(endereco.getComplemento());
                enderecoEntity.setCliente(clienteEntity);
                
                enderecosEntity.add(enderecoEntity);
            }
        }
        
        clienteEntity.setEnderecos(enderecosEntity);

        return clienteEntity;
    }

    public Cliente paraCliente(ClienteEntity clienteEntity) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteEntity.getId());
        cliente.setNome(clienteEntity.getNome());
        cliente.setCpf(clienteEntity.getCpfCnpj());

        List<Endereco> enderecos = new ArrayList<>();
        if (clienteEntity.getEnderecos() != null) {
            for (EnderecoEntity enderecoEntity : clienteEntity.getEnderecos()) {
            	
                Endereco endereco = new Endereco();
                endereco.setRua(enderecoEntity.getRua());
                endereco.setCep(enderecoEntity.getCep());
                endereco.setNumero(enderecoEntity.getNumero());
                endereco.setComplemento(enderecoEntity.getComplemento());

                enderecos.add(endereco);
            }
        }
        cliente.setEnderecos(enderecos);

        return cliente;
    }
    
}
