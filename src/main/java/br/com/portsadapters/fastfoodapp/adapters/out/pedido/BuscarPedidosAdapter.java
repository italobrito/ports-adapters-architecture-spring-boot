package br.com.portsadapters.fastfoodapp.adapters.out.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.PedidoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.ports.out.pedido.BuscarPedidosOutputPort;

@Component
public class BuscarPedidosAdapter implements BuscarPedidosOutputPort {
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public List<PedidoEntity> buscarTodos() {
		return pedidoRepository.findAll();
	}
}
