package br.com.portsadapters.fastfoodapp.application.ports.out.pedido;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoStatus;

public interface BuscarPedidosPorStatusOutputPort {
	List<PedidoEntity> buscarPedidosPorStatus(TipoStatus tipoStatus);
}
