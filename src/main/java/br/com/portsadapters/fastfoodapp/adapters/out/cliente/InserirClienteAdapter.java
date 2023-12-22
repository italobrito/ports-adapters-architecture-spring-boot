package br.com.portsadapters.fastfoodapp.adapters.out.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.ClienteRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.ClienteEntityMapper;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.ports.out.cliente.InserirClienteOutputPort;

@Component
public class InserirClienteAdapter implements InserirClienteOutputPort {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteEntityMapper clienteEntityMapper;

	@Override
	public void inserir(Cliente cliente) {
		ClienteEntity clienteEntity = clienteEntityMapper.paraClienteEntity(cliente);
		clienteRepository.save(clienteEntity);
	}
	
}
