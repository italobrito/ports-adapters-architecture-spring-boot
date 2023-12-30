package br.com.portsadapters.fastfoodapp.application.ports.in.pedido;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoStatus;

public interface AtualizarPedidoStatusInputPort {
	int atualizarStatusPedido(Long id, TipoStatus tipoStatus);
}
