package br.com.portsadapters.fastfoodapp.application.ports.out.pedido;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;

public interface InserirPedidoOutputPort {
	PedidoEntity inserir(Pedido pedido);
}
