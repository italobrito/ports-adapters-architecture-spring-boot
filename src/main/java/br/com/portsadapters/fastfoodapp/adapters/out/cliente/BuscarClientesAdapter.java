package br.com.portsadapters.fastfoodapp.adapters.out.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.ClienteRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.application.ports.out.cliente.BuscarClientesOutputPort;

@Component
public class BuscarClientesAdapter implements BuscarClientesOutputPort {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<ClienteEntity> buscarTodos() {
		return clienteRepository.findAll();
	}

}
