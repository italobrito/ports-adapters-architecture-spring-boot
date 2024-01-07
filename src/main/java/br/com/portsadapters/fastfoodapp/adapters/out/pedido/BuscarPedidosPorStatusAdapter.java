package br.com.portsadapters.fastfoodapp.adapters.out.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.PedidoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoStatus;
import br.com.portsadapters.fastfoodapp.application.ports.out.pedido.BuscarPedidosPorStatusOutputPort;

@Component
public class BuscarPedidosPorStatusAdapter implements BuscarPedidosPorStatusOutputPort {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public List<PedidoEntity> buscarPedidosPorStatus(TipoStatus tipoStatus) {
		return pedidoRepository.buscarPedidosPorStatus(tipoStatus.toString());
	}
}

