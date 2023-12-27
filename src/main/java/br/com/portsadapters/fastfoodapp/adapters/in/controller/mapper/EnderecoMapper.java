package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.EnderecoRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;
import br.com.portsadapters.fastfoodapp.application.core.domain.Endereco;

@Component
public class EnderecoMapper {

	public Endereco paraEndereco(EnderecoRequest enderecoRequest) {
		Endereco endereco = new Endereco();
		endereco.setId(enderecoRequest.getId());
		endereco.setRua(enderecoRequest.getRua());
		endereco.setCep(enderecoRequest.getCep());
		endereco.setNumero(enderecoRequest.getNumero());
		endereco.setComplemento(enderecoRequest.getComplemento());
		return endereco;
	}

	public EnderecoEntity paraEnderecoEntity(Endereco endereco) {
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		enderecoEntity.setId(endereco.getId());
		enderecoEntity.setRua(endereco.getRua());
		enderecoEntity.setCep(endereco.getCep());
		enderecoEntity.setNumero(endereco.getNumero());
		enderecoEntity.setComplemento(endereco.getComplemento());
		return enderecoEntity;
	}

	public EnderecoEntity paraEnderecoEntity(EnderecoRequest enderecoRequest) {
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		enderecoEntity.setId(enderecoRequest.getId());
		enderecoEntity.setRua(enderecoRequest.getRua());
		enderecoEntity.setCep(enderecoRequest.getCep());
		enderecoEntity.setNumero(enderecoRequest.getNumero());
		enderecoEntity.setComplemento(enderecoRequest.getComplemento());
		return enderecoEntity;
	}

	public List<EnderecoEntity> paraListaEnderecoEntity(List<EnderecoRequest> enderecosRequest) {
		List<EnderecoEntity> enderecosEntity = new ArrayList<>();

		for (EnderecoRequest enderecoRequest : enderecosRequest) {
			EnderecoEntity enderecoEntity = new EnderecoEntity();
			enderecoEntity.setId(enderecoRequest.getId());
			enderecoEntity.setRua(enderecoRequest.getRua());
			enderecoEntity.setCep(enderecoRequest.getCep());
			enderecoEntity.setNumero(enderecoRequest.getNumero());
			enderecoEntity.setComplemento(enderecoRequest.getComplemento());
			enderecosEntity.add(enderecoEntity);
		}

		return enderecosEntity;
	}

	public EnderecoRequest paraEnderecoRequest(Endereco endereco) {
		EnderecoRequest enderecoRequest = new EnderecoRequest();
		enderecoRequest.setId(endereco.getId());
		enderecoRequest.setRua(endereco.getRua());
		enderecoRequest.setCep(endereco.getCep());
		enderecoRequest.setNumero(endereco.getNumero());
		enderecoRequest.setComplemento(endereco.getComplemento());
		return enderecoRequest;
	}

	public List<Endereco> paraListaEndereco(List<EnderecoRequest> listaEnderecoRequest) {
		List<Endereco> listaEndereco = new ArrayList<>();
		for (EnderecoRequest enderecoRequest : listaEnderecoRequest) {
			Endereco endereco = new Endereco();
			endereco.setId(enderecoRequest.getId());
			endereco.setRua(enderecoRequest.getRua());
			endereco.setCep(enderecoRequest.getCep());
			endereco.setNumero(enderecoRequest.getNumero());
			endereco.setComplemento(enderecoRequest.getComplemento());
			listaEndereco.add(endereco);
		}
		return listaEndereco;
	}

	public List<EnderecoEntity> paraEnderecoEntity(List<Endereco> listaEndereco) {

		List<EnderecoEntity> listaEnderecoEntity = new ArrayList<>();

		if (listaEndereco != null) {

			for (Endereco endereco : listaEndereco) {
				EnderecoEntity enderecoEntity = new EnderecoEntity();
				enderecoEntity.setId(endereco.getId());
				enderecoEntity.setRua(endereco.getRua());
				enderecoEntity.setCep(endereco.getCep());
				enderecoEntity.setNumero(endereco.getNumero());
				enderecoEntity.setComplemento(endereco.getComplemento());
				listaEnderecoEntity.add(enderecoEntity);
			}

		}

		return listaEnderecoEntity;
	}

	public List<EnderecoEntity> paraEnderecoEntity(List<Endereco> listaEndereco, Empresa empresa) {

		List<EnderecoEntity> listaEnderecoEntity = new ArrayList<>();

		if (listaEndereco != null) {

			for (Endereco endereco : listaEndereco) {
				EnderecoEntity enderecoEntity = new EnderecoEntity();
				enderecoEntity.setId(endereco.getId());
				enderecoEntity.setRua(endereco.getRua());
				enderecoEntity.setCep(endereco.getCep());
				enderecoEntity.setNumero(endereco.getNumero());
				enderecoEntity.setComplemento(endereco.getComplemento());
				enderecoEntity.setEmpresa(paraEmpresaEntiy(empresa));
				listaEnderecoEntity.add(enderecoEntity);
			}

		}

		return listaEnderecoEntity;
	}
	
	public List<EnderecoEntity> paraEnderecoEntity(List<Endereco> listaEndereco, EmpresaEntity empresa) {

		List<EnderecoEntity> listaEnderecoEntity = new ArrayList<>();

		if (listaEndereco != null) {

			for (Endereco endereco : listaEndereco) {
				EnderecoEntity enderecoEntity = new EnderecoEntity();
				enderecoEntity.setId(endereco.getId());
				enderecoEntity.setRua(endereco.getRua());
				enderecoEntity.setCep(endereco.getCep());
				enderecoEntity.setNumero(endereco.getNumero());
				enderecoEntity.setComplemento(endereco.getComplemento());
				enderecoEntity.setEmpresa(empresa);
				listaEnderecoEntity.add(enderecoEntity);
			}

		}

		return listaEnderecoEntity;
	}

	public EmpresaEntity paraEmpresaEntiy(Empresa empresa) {
		EmpresaEntity empresaEntity = new EmpresaEntity();
		empresaEntity.setId(empresa.getId());
		empresaEntity.setNome(empresa.getNome());
		empresaEntity.setCnpj(empresa.getCnpj());
		empresaEntity.setAtivo(empresa.getAtivo());

		List<EnderecoEntity> enderecosEntity = paraEnderecoEntity(empresa.getEnderecos());

		List<EnderecoEntity> enderecos = new ArrayList<>();

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

		empresaEntity.setEnderecos(enderecos);
		empresaEntity.setClientes(deClienteParaClienteEntity(empresa.getClientes()));

		return empresaEntity;
	}
	
    public List<ClienteEntity> deClienteParaClienteEntity(List<Cliente> clientes) {
        List<ClienteEntity> clientesEntity = new ArrayList<>();
        for (Cliente cliente : clientes) {
            ClienteEntity clienteEntity = new ClienteEntity();
            
            clienteEntity.setId(cliente.getId());

            clienteEntity.setNome(cliente.getNome());
            clienteEntity.setCpfCnpj(cliente.getCpfCnpj());
            clienteEntity.setEnderecos(paraEnderecoEntity(cliente.getEnderecos()));

            clienteEntity.setEmpresa(paraEmpresaEntiy(cliente.getEmpresa()));

            clientesEntity.add(clienteEntity);
        }
        return clientesEntity;
    }

	public List<EnderecoEntity> paraEnderecoEntity(List<Endereco> listaEndereco, ClienteEntity clienteEntity) {

		List<EnderecoEntity> listaEnderecoEntity = new ArrayList<>();

		System.out.print(listaEndereco);

		if (listaEndereco != null) {

			for (Endereco endereco : listaEndereco) {
				EnderecoEntity enderecoEntity = new EnderecoEntity();
				enderecoEntity.setId(endereco.getId());
				enderecoEntity.setRua(endereco.getRua());
				enderecoEntity.setCep(endereco.getCep());
				enderecoEntity.setNumero(endereco.getNumero());
				enderecoEntity.setComplemento(endereco.getComplemento());
				enderecoEntity.setCliente(clienteEntity);
				listaEnderecoEntity.add(enderecoEntity);
			}

		}

		return listaEnderecoEntity;
	}

	public List<EnderecoRequest> paraListaEnderecoRequest(List<Endereco> listaEndereco) {
		List<EnderecoRequest> listaEnderecoRequest = new ArrayList<>();
		for (Endereco endereco : listaEndereco) {
			EnderecoRequest enderecoRequest = new EnderecoRequest();
			enderecoRequest.setId(endereco.getId());
			enderecoRequest.setRua(endereco.getRua());
			enderecoRequest.setCep(endereco.getCep());
			enderecoRequest.setNumero(endereco.getNumero());
			enderecoRequest.setComplemento(endereco.getComplemento());
			listaEnderecoRequest.add(enderecoRequest);
		}
		return listaEnderecoRequest;
	}

	public List<Endereco> paraEndereco(List<EnderecoEntity> listaEnderecoEntity) {
		List<Endereco> listaEndereco = new ArrayList<>();
		for (EnderecoEntity enderecoEntity : listaEnderecoEntity) {
			Endereco endereco = new Endereco();
			endereco.setId(enderecoEntity.getId());
			endereco.setRua(enderecoEntity.getRua());
			endereco.setCep(enderecoEntity.getCep());
			endereco.setNumero(enderecoEntity.getNumero());
			endereco.setComplemento(enderecoEntity.getComplemento());
			listaEndereco.add(endereco);
		}
		return listaEndereco;
	}

}
