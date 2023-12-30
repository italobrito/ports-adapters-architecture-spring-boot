package br.com.portsadapters.fastfoodapp.application.ports.out.pedido;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoStatus;

public interface AtualizarPedidoStatusOutputPort {
	int atualizarStatusPedido(Long id, TipoStatus tipoStatus);
}
