package br.com.portsadapters.fastfoodapp.adapters.out.pedido;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.PedidoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.ports.out.pedido.BuscarPedidoPorIdOutputPort;

@Component
public class BuscarPedidoPorIdAdapter implements BuscarPedidoPorIdOutputPort {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public Optional<PedidoEntity> buscarPorId(Long id) {
		PedidoEntity pedidoEntity = pedidoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Pedido não encontrado com o ID fornecido: " + id));
		return Optional.ofNullable(pedidoEntity);
	}
	
}
