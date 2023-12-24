package br.com.portsadapters.fastfoodapp.application.core.usecase.cliente;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.application.ports.in.cliente.BuscarClientePorIdInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.cliente.BuscarClientePorIdOutputPort;

public class BuscarClientePorIdUseCase implements BuscarClientePorIdInputPort {
	
	private BuscarClientePorIdOutputPort buscarClientePorIdOutputPort;
	
	public BuscarClientePorIdUseCase(BuscarClientePorIdOutputPort buscarClientePorIdOutputPort) {
		this.buscarClientePorIdOutputPort = buscarClientePorIdOutputPort;
	}

	@Override
	public Optional<ClienteEntity> buscarPorId(Long id) {
		Optional<ClienteEntity> cliente = buscarClientePorIdOutputPort.buscarPorId(id);
		if (cliente == null) {
			 throw new RuntimeException("Cliente não encontrado");
		}
		return cliente;
	}

}
