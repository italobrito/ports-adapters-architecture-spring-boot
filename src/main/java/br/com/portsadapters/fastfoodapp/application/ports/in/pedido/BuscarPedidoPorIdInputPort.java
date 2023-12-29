package br.com.portsadapters.fastfoodapp.application.ports.in.pedido;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;

public interface BuscarPedidoPorIdInputPort {
	Optional<PedidoEntity> buscarPorId(Long id);
}
