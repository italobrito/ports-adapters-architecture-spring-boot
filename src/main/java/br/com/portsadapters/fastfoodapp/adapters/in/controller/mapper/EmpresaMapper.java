package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.ClienteRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.EmpresaRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.ClienteResponse;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.EmpresaResponse;
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
    
    public List<ClienteEntity> paraListaClienteEntity(List<Cliente> clientes) {
        List<ClienteEntity> clientesEntity = new ArrayList<>();

        for (Cliente cliente : clientes) {
            ClienteEntity clienteEntity = new ClienteEntity();
            clienteEntity.setId(cliente.getId());
            clienteEntity.setNome(cliente.getNome());
            clienteEntity.setCpfCnpj(cliente.getCpfCnpj());

            if (cliente.getEmpresa() != null) {
                clienteEntity.setEmpresa(paraEmpresaEntiy(cliente.getEmpresa()));
            }

            clienteEntity.setEnderecos(enderecoMapper.paraEnderecoEntity(cliente.getEnderecos(), clienteEntity));

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
    
    public List<ClienteResponse> paraClienteResponse(List<ClienteEntity> clienteEntities) {
        List<ClienteResponse> clienteResponses = new ArrayList<>();
        for (ClienteEntity clienteEntity : clienteEntities) {
            ClienteResponse clienteResponse = new ClienteResponse();
            clienteResponse.setId(clienteEntity.getId());
            clienteResponse.setNome(clienteEntity.getNome());
            clienteResponse.setCpfCnpj(clienteEntity.getCpfCnpj());
            if (clienteEntity.getEnderecos() != null) {
                clienteResponse.setEnderecos(enderecoMapper.paraEnderecoResponse(clienteEntity.getEnderecos()));
            }
            clienteResponses.add(clienteResponse);
        }
        return clienteResponses;
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
    	empresaEntity.setId(empresa.getId());
    	empresaEntity.setNome(empresa.getNome());
    	empresaEntity.setCnpj(empresa.getCnpj());
    	empresaEntity.setAtivo(empresa.getAtivo());
    	
    	List<EnderecoEntity> enderecosEntity = enderecoMapper.paraEnderecoEntity(empresa.getEnderecos(), empresaEntity);
    	
    	List<ClienteEntity> clientesEntity = new ArrayList<>();
    	
    	if (empresa.getClientes() != null) {
			clientesEntity = paraListaClienteEntity(empresa.getClientes());
    	}
    	
    	List<EnderecoEntity> enderecos = new ArrayList<>();
    	
    	List<ClienteEntity> clientes = new ArrayList<>();
    	
        if (enderecosEntity != null) {
            
            for (EnderecoEntity enderecoEntity : enderecosEntity) {
            	
            	EnderecoEntity enderecoEnt = new EnderecoEntity();
            	
            	enderecoEnt.setCep(enderecoEntity.getCep());
            	enderecoEnt.setComplemento(enderecoEntity.getComplemento());
            	enderecoEnt.setNumero(enderecoEntity.getNumero());
            	enderecoEnt.setRua(enderecoEntity.getRua());
            	enderecoEnt.setId(enderecoEntity.getId());
            	enderecoEnt.setEmpresa(empresaEntity);
            	
            	enderecos.add(enderecoEntity);
            	
            }
            
        }
        
        if (clientesEntity != null) {
            
            for (ClienteEntity clienteEntity : clientesEntity) {
            	
            	ClienteEntity clienteEnt = new ClienteEntity();
            	
            	clienteEnt.setCpfCnpj(clienteEntity.getCpfCnpj());
            	clienteEnt.setNome(clienteEntity.getNome());
            	clienteEnt.setId(clienteEntity.getId());
            	clienteEnt.setEmpresa(empresaEntity);
            	
            	clientes.add(clienteEnt);
            	
            }
            
        }
    	
    	empresaEntity.setEnderecos(enderecos);
    	empresaEntity.setClientes(clientes);
    	
        return empresaEntity;
    }
	
    public EmpresaEntity paraEmpresaEntiy(EmpresaRequest empresaRequest) {
    	EmpresaEntity empresaEntity = new EmpresaEntity();
    	empresaEntity.setId(empresaRequest.getId());
    	empresaEntity.setNome(empresaRequest.getNome());
    	empresaEntity.setCnpj(empresaRequest.getCnpj());
    	empresaEntity.setAtivo(empresaRequest.getAtivo());
    	empresaEntity.setEnderecos(enderecoMapper.paraListaEnderecoEntity(empresaRequest.getEnderecos()));
    	empresaEntity.setClientes(paraClienteEntity(empresaRequest.getClientes()));;
        return empresaEntity;
    }

    public Empresa paraEmpresa(EmpresaRequest empresaRequest) {
        Empresa empresa = new Empresa();
        empresa.setId(empresaRequest.getId());
        empresa.setNome(empresaRequest.getNome());
        empresa.setCnpj(empresaRequest.getCnpj());
        empresa.setAtivo(empresaRequest.getAtivo());
        empresa.setEnderecos(enderecoMapper.paraListaEndereco(empresaRequest.getEnderecos()));
        if (empresaRequest.getClientes() != null) {
        	empresa.setClientes(paraCliente(empresaRequest.getClientes()));
        }
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
	
    
    public List<EmpresaResponse> paraEmpresaResponse(List<EmpresaEntity> empresaEntity) {
    	
    	List<EmpresaResponse> empresasResponse =  new ArrayList<>();
    	
        for (EmpresaEntity empresa : empresaEntity) {
        	
        	EmpresaResponse empresaResponse = new EmpresaResponse();
        	
        	empresaResponse.setId(empresa.getId());
        	empresaResponse.setNome(empresa.getNome());
        	empresaResponse.setCnpj(empresa.getCnpj());
        	empresaResponse.setAtivo(empresa.getAtivo());
        	
            if (empresa.getEnderecos() != null) {
            	empresaResponse.setEnderecos(enderecoMapper.paraEnderecoResponse(empresa.getEnderecos()));
            }
            
            if (empresa.getClientes() != null) {
            	empresaResponse.setClientes(paraClienteResponse(empresa.getClientes()));
            }
            
            empresasResponse.add(empresaResponse);
        }
        
    	return empresasResponse;
    }
    
    public EmpresaResponse paraEmpresaResponse(EmpresaEntity empresaEntity) {
        EmpresaResponse empresaResponse = new EmpresaResponse();

        empresaResponse.setId(empresaEntity.getId());
        empresaResponse.setNome(empresaEntity.getNome());
        empresaResponse.setCnpj(empresaEntity.getCnpj());
        empresaResponse.setAtivo(empresaEntity.getAtivo());

        if (empresaEntity.getEnderecos() != null) {
            empresaResponse.setEnderecos(enderecoMapper.paraEnderecoResponse(empresaEntity.getEnderecos()));
        }

        if (empresaEntity.getClientes() != null) {
            empresaResponse.setClientes(paraClienteResponse(empresaEntity.getClientes()));
        }

        return empresaResponse;
    }

    
}
