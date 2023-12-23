package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	
	@Autowired
	private ClienteMapper clienteMapper;
	
    private Cliente paraCliente(ClienteEntity clienteEntity) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteEntity.getId());
        cliente.setNome(clienteEntity.getNome());
        cliente.setCpfCnpj(clienteEntity.getCpfCnpj());
        return cliente;
    }
	
	private Endereco paraEndereco(EnderecoEntity enderecoEntity) {
        Endereco endereco = new Endereco();
        endereco.setId(enderecoEntity.getId());
        endereco.setRua(enderecoEntity.getRua());
        endereco.setCep(enderecoEntity.getCep());
        endereco.setNumero(enderecoEntity.getNumero());
        endereco.setComplemento(enderecoEntity.getComplemento());
        return endereco;
    }
	
    public EmpresaEntity paraEmpresaEntiy(EmpresaRequest empresaRequest) {
    	EmpresaEntity empresaEntity = new EmpresaEntity();
    	empresaEntity.setNome(empresaRequest.getNome());
    	empresaEntity.setCnpj(empresaRequest.getCnpj());
    	empresaEntity.setAtivo(empresaRequest.getAtivo());
    	empresaEntity.setEnderecos(enderecoMapper.paraListaEnderecoEntity(empresaRequest.getEnderecos()));
    	empresaEntity.setClientes(clienteMapper.paraClienteEntity(empresaRequest.getClientes()));
        return empresaEntity;
    }

    public Empresa paraEmpresa(EmpresaRequest empresaRequest) {
        Empresa empresa = new Empresa();
        empresa.setNome(empresaRequest.getNome());
        empresa.setCnpj(empresaRequest.getCnpj());
        empresa.setAtivo(empresaRequest.getAtivo());
        empresa.setEnderecos(enderecoMapper.paraListaEndereco(empresaRequest.getEnderecos()));
        empresa.setClientes(clienteMapper.paraCliente(empresaRequest.getClientes()));
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
