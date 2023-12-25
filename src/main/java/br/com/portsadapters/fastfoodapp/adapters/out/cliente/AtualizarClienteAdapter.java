package br.com.portsadapters.fastfoodapp.adapters.out.cliente;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.ClienteMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.ClienteRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.EnderecoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.ports.out.cliente.AtualizarClienteOutputPort;

@Component
public class AtualizarClienteAdapter implements AtualizarClienteOutputPort {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	@Override
	public ClienteEntity atualizar(Cliente cliente) {
		ClienteEntity clienteEntity = clienteMapper.paraClienteEntity(cliente);

		List<EnderecoEntity> enderecosEntityAlterado = enderecoRepository.saveAll(clienteEntity.getEnderecos());
		
		Optional<ClienteEntity> clienteEntityEncontrado = clienteRepository.findById(clienteEntity.getId());
		
		if(clienteEntityEncontrado.isPresent()) {
			clienteEntity.setEmpresa(clienteEntityEncontrado.get().getEmpresa());
		}
		
		ClienteEntity clienteEntityAlterado = clienteRepository.save(clienteEntity);
		
		clienteEntityAlterado.setEnderecos(enderecosEntityAlterado);
        
		return clienteEntityAlterado;
	}

}
