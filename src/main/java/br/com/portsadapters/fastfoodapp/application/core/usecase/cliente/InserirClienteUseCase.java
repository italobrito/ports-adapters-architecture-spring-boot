package br.com.portsadapters.fastfoodapp.application.core.usecase.cliente;

import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.ports.in.cliente.InserirClienteInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.cliente.InserirClienteOutputPort;

public class InserirClienteUseCase implements InserirClienteInputPort {

	private final InserirClienteOutputPort inserirClienteOutputPort;
	
	public InserirClienteUseCase(InserirClienteOutputPort inserirClienteOutputPort) {
		this.inserirClienteOutputPort = inserirClienteOutputPort;
	}

	@Override
	public void inserir(Cliente cliente) {
		this.inserirClienteOutputPort.inserir(cliente);
	}
	
}
