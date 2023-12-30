package br.com.portsadapters.fastfoodapp.application.ports.in.pedido;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;

public interface BuscarPedidosInputPort {
	List<PedidoEntity> buscarTodos();
}

