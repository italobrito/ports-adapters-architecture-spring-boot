package br.com.portsadapters.fastfoodapp.application.core.usecase.cliente;

import java.util.List;

import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.ports.in.cliente.BuscarClientesInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.cliente.BuscarClientesOutputPort;

public class BuscarClientesUseCase implements BuscarClientesInputPort {
	
	private final BuscarClientesOutputPort buscarClientesOutputPort;
	
	public BuscarClientesUseCase(BuscarClientesOutputPort buscarClientesOutputPort) {
		this.buscarClientesOutputPort = buscarClientesOutputPort;
	}

	@Override
	public List<Cliente> buscarTodos() {
		List<Cliente> clientes = buscarClientesOutputPort.buscarTodos();
		return clientes;
	}

}
