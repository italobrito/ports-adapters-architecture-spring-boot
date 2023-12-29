package br.com.portsadapters.fastfoodapp.adapters.out.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.PedidoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.PedidoEntityMapper;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;
import br.com.portsadapters.fastfoodapp.application.ports.out.pedido.InserirPedidoOutputPort;

@Component
public class InserirPedidoAdapter implements InserirPedidoOutputPort {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoEntityMapper pedidoEntityMapper;
	
	@Override
	public PedidoEntity inserir(Pedido pedido) {

		PedidoEntity pedidoEntity = pedidoEntityMapper.paraPedidoEntity(pedido);
		
		PedidoEntity pedidoSalvo = pedidoRepository.save(pedidoEntity);
		
		pedidoEntity.setId(pedidoSalvo.getId());
		
		return pedidoEntity;
	}
}
