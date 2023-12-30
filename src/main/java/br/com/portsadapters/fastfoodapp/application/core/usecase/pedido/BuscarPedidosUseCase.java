package br.com.portsadapters.fastfoodapp.application.core.usecase.pedido;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.ports.in.pedido.BuscarPedidosInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.pedido.BuscarPedidosOutputPort;

public class BuscarPedidosUseCase implements BuscarPedidosInputPort {
	private final BuscarPedidosOutputPort buscarPedidosOutputPort;

	public BuscarPedidosUseCase(BuscarPedidosOutputPort buscarPedidosOutputPort) {
		this.buscarPedidosOutputPort = buscarPedidosOutputPort;
	}

	@Override
	public List<PedidoEntity> buscarTodos() {
		List<PedidoEntity> pedidos = buscarPedidosOutputPort.buscarTodos();
		return pedidos;
	}
}
