package br.com.portsadapters.fastfoodapp.application.core.usecase.cliente;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.ports.in.cliente.InserirClienteInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.cliente.InserirClienteOutputPort;

public class InserirClienteUseCase implements InserirClienteInputPort {

	private final InserirClienteOutputPort inserirClienteOutputPort;
	
	public InserirClienteUseCase(InserirClienteOutputPort inserirClienteOutputPort) {
		this.inserirClienteOutputPort = inserirClienteOutputPort;
	}

	@Override
	public ClienteEntity inserir(Cliente cliente) {
		return this.inserirClienteOutputPort.inserir(cliente);
	}

	@Override
	public List<ClienteEntity> inserirTodos(List<Cliente> clientes) {
		return this.inserirClienteOutputPort.inserirTodos(clientes);
	}
	
}
