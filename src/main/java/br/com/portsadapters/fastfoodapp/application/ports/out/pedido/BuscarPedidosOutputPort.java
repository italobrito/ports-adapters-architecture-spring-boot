package br.com.portsadapters.fastfoodapp.application.ports.out.pedido;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;

public interface BuscarPedidosOutputPort {
	List<PedidoEntity> buscarTodos();
}


