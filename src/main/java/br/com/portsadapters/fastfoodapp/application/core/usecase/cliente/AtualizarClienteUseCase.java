package br.com.portsadapters.fastfoodapp.application.core.usecase.cliente;

import java.util.Optional;

/*import org.springframework.beans.factory.annotation.Autowired;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.ClienteMapper;*/
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.ports.in.cliente.AtualizarClienteInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.cliente.AtualizarClienteOutputPort;

import br.com.portsadapters.fastfoodapp.application.ports.out.cliente.BuscarClientePorIdOutputPort;

public class AtualizarClienteUseCase implements AtualizarClienteInputPort {

	private final AtualizarClienteOutputPort atualizarClienteOutputPort;

	private final BuscarClientePorIdOutputPort buscarClientePorIdOutputPort;

	public AtualizarClienteUseCase(AtualizarClienteOutputPort atualizarClienteOutputPort,
			BuscarClientePorIdOutputPort buscarClientePorIdOutputPort) {
		this.atualizarClienteOutputPort = atualizarClienteOutputPort;
		this.buscarClientePorIdOutputPort = buscarClientePorIdOutputPort;
	}

	@Override
	public ClienteEntity atualizar(Cliente cliente) {
		Optional<ClienteEntity> clienteEntity = buscarClientePorIdOutputPort.buscarPorId(cliente.getId());
		if (clienteEntity.isEmpty()) {
			throw new RuntimeException("Cliente não encontrado");
		}
		return atualizarClienteOutputPort.atualizar(cliente);
	}

}
