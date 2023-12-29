package br.com.portsadapters.fastfoodapp.application.ports.out.pedido;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;

public interface BuscarPedidoPorIdOutputPort {
	Optional<PedidoEntity> buscarPorId(Long id);
}
