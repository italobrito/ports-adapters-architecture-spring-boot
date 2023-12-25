package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.ClienteRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.EmpresaRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;
import br.com.portsadapters.fastfoodapp.application.core.domain.Endereco;

@Component
public class EmpresaMapper {
	
	@Autowired
	private EnderecoMapper enderecoMapper;
	
	/*
	 * @Autowired private ClienteMapper clienteMapper;
	 */
	
	/*
	 * Métodos para CLIENTES
	 */
    public List<ClienteEntity> deClienteParaClienteEntity(List<Cliente> clientes) {
        List<ClienteEntity> clientesEntity = new ArrayList<>();
        for (Cliente cliente : clientes) {
            ClienteEntity clienteEntity = new ClienteEntity();
            
            clienteEntity.setId(cliente.getId());

            clienteEntity.setNome(cliente.getNome());
            clienteEntity.setCpfCnpj(cliente.getCpfCnpj());
            
            clienteEntity.setEnderecos(enderecoMapper.paraEnderecoEntity(cliente.getEnderecos()));
            
            if (cliente.getEmpresa() != null) {
            	clienteEntity.setEmpresa(paraEmpresaEntiy(cliente.getEmpresa()));
            }

            clientesEntity.add(clienteEntity);
        }
        return clientesEntity;
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
	
    private Cliente paraCliente(ClienteEntity clienteEntity) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteEntity.getId());
        cliente.setNome(clienteEntity.getNome());
        cliente.setCpfCnpj(clienteEntity.getCpfCnpj());
        return cliente;
    }
    
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
	
	/*
	 * Métodos para Endereço
	 */
	private Endereco paraEndereco(EnderecoEntity enderecoEntity) {
        Endereco endereco = new Endereco();
        endereco.setId(enderecoEntity.getId());
        endereco.setRua(enderecoEntity.getRua());
        endereco.setCep(enderecoEntity.getCep());
        endereco.setNumero(enderecoEntity.getNumero());
        endereco.setComplemento(enderecoEntity.getComplemento());
        return endereco;
    }
	
	/*
	 * Métodos para Endereço
	 */
    public EmpresaEntity paraEmpresaEntiy(Empresa empresa) {
    	EmpresaEntity empresaEntity = new EmpresaEntity();
    	empresaEntity.setNome(empresa.getNome());
    	empresaEntity.setCnpj(empresa.getCnpj());
    	empresaEntity.setAtivo(empresa.getAtivo());
    	empresaEntity.setEnderecos(enderecoMapper.paraEnderecoEntity(empresa.getEnderecos()));
    	empresaEntity.setClientes(deClienteParaClienteEntity(empresa.getClientes()));
        return empresaEntity;
    }
	
    public EmpresaEntity paraEmpresaEntiy(EmpresaRequest empresaRequest) {
    	EmpresaEntity empresaEntity = new EmpresaEntity();
    	empresaEntity.setNome(empresaRequest.getNome());
    	empresaEntity.setCnpj(empresaRequest.getCnpj());
    	empresaEntity.setAtivo(empresaRequest.getAtivo());
    	empresaEntity.setEnderecos(enderecoMapper.paraListaEnderecoEntity(empresaRequest.getEnderecos()));
    	empresaEntity.setClientes(paraClienteEntity(empresaRequest.getClientes()));;
        return empresaEntity;
    }

    public Empresa paraEmpresa(EmpresaRequest empresaRequest) {
        Empresa empresa = new Empresa();
        empresa.setNome(empresaRequest.getNome());
        empresa.setCnpj(empresaRequest.getCnpj());
        empresa.setAtivo(empresaRequest.getAtivo());
        empresa.setEnderecos(enderecoMapper.paraListaEndereco(empresaRequest.getEnderecos()));
        empresa.setClientes(paraCliente(empresaRequest.getClientes()));
        return empresa;
    }
    
    public Empresa paraEmpresa(EmpresaEntity empresaEntity) {
        Empresa empresa = new Empresa();
        empresa.setId(empresaEntity.getId());
        empresa.setNome(empresaEntity.getNome());
        empresa.setCnpj(empresaEntity.getCnpj());
        empresa.setAtivo(empresaEntity.getAtivo());
        
        if (empresaEntity.getEnderecos() != null) {
            List<Endereco> enderecos = new ArrayList<>();
            for (EnderecoEntity enderecoEntity : empresaEntity.getEnderecos()) {
                Endereco endereco = paraEndereco(enderecoEntity);
                enderecos.add(endereco);
            }
            empresa.setEnderecos(enderecos);
        }
        
        if (empresaEntity.getClientes() != null) {
            List<Cliente> clientes = new ArrayList<>();
            for (ClienteEntity clienteEntity : empresaEntity.getClientes()) {
                Cliente cliente = paraCliente(clienteEntity);
                clientes.add(cliente);
            }
            empresa.setClientes(clientes);
        }
        
        return empresa;
    }
	
}
