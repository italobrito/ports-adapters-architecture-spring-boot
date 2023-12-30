package br.com.portsadapters.fastfoodapp.adapters.out.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.PedidoRepository;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoStatus;
import br.com.portsadapters.fastfoodapp.application.ports.out.pedido.AtualizarPedidoStatusOutputPort;

@Component
public class AtualizarPedidoStatusAdapter implements AtualizarPedidoStatusOutputPort  {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public int atualizarStatusPedido(Long id, TipoStatus status) {
		return pedidoRepository.atualizarStatus(id, status.toString());
	}

}
