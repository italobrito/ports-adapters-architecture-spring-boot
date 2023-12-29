package br.com.portsadapters.fastfoodapp.application.core.usecase.pedido;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;
import br.com.portsadapters.fastfoodapp.application.ports.in.pedido.InserirPedidoInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.pedido.InserirPedidoOutputPort;

public class InserirPedidoUseCase implements InserirPedidoInputPort {
	
	private final InserirPedidoOutputPort inserirPedidoOutputPort;
	
	public InserirPedidoUseCase(InserirPedidoOutputPort inserirPedidoOutputPort) {
		this.inserirPedidoOutputPort = inserirPedidoOutputPort;
	}
	
	@Override
	public PedidoEntity inserir(Pedido Pedido) {
		return this.inserirPedidoOutputPort.inserir(Pedido);
	}	
	
}
