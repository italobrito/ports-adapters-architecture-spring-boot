package br.com.portsadapters.fastfoodapp.application.core.usecase.pedido;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.ports.in.pedido.BuscarPedidoPorIdInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.pedido.BuscarPedidoPorIdOutputPort;

public class BuscarPedidoPorIdUseCase implements BuscarPedidoPorIdInputPort {

	private final BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort;
	
	public BuscarPedidoPorIdUseCase(BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort) {
		this.buscarPedidoPorIdOutputPort = buscarPedidoPorIdOutputPort;
	}
	
	@Override
	public Optional<PedidoEntity> buscarPorId(Long id) {
		Optional<PedidoEntity> pedido = buscarPedidoPorIdOutputPort.buscarPorId(id);
		if (pedido == null) {
			 throw new RuntimeException("Pedido não encontrado");
		}
		return pedido;
	}

}
