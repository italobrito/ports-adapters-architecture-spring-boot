package br.com.portsadapters.fastfoodapp.application.ports.in.pedido;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;

public interface InserirPedidoInputPort {
	PedidoEntity inserir(Pedido pedido);
}
