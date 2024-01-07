package br.com.portsadapters.fastfoodapp.application.core.usecase.pedido;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoStatus;
import br.com.portsadapters.fastfoodapp.application.ports.in.pedido.BuscarPedidosPorStatusInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.pedido.BuscarPedidosPorStatusOutputPort;

public class BuscarPedidosPorStatusUseCase implements BuscarPedidosPorStatusInputPort {

	private final BuscarPedidosPorStatusOutputPort buscarPedidosPorStatusOutputPort;

	public BuscarPedidosPorStatusUseCase(BuscarPedidosPorStatusOutputPort buscarPedidosPorStatusOutputPort) {
		this.buscarPedidosPorStatusOutputPort = buscarPedidosPorStatusOutputPort;
	}

	@Override
	public List<PedidoEntity> buscarPedidosPorStatus(TipoStatus tipoStatus) {
		List<PedidoEntity> pedidosStatus = buscarPedidosPorStatusOutputPort.buscarPedidosPorStatus(tipoStatus);
		return pedidosStatus;
	}
}
