package br.com.portsadapters.fastfoodapp.application.core.usecase.pedido;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoStatus;
import br.com.portsadapters.fastfoodapp.application.ports.in.pedido.AtualizarPedidoStatusInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.pedido.AtualizarPedidoStatusOutputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.pedido.BuscarPedidoPorIdOutputPort;

public class AtualizarPedidoStatusUseCase implements AtualizarPedidoStatusInputPort {
	
	private final AtualizarPedidoStatusOutputPort atualizarPedidoStatusOutputPort;

	private final BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort;

	public AtualizarPedidoStatusUseCase(AtualizarPedidoStatusOutputPort atualizarPedidoStatusOutputPort,
			BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort) {
		this.atualizarPedidoStatusOutputPort = atualizarPedidoStatusOutputPort;
		this.buscarPedidoPorIdOutputPort = buscarPedidoPorIdOutputPort;
	}

	@Override
	public int atualizarStatusPedido(Long id, TipoStatus tipoStatus) {
		Optional<PedidoEntity> pedido = buscarPedidoPorIdOutputPort.buscarPorId(id);
		if (pedido == null) {
			 throw new RuntimeException("Pedido não encontrado");
		}
		return atualizarPedidoStatusOutputPort.atualizarStatusPedido(id, tipoStatus);
	}

}
