package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.ClienteMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;

@Component
public class PedidoEntityMapper {
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	@Autowired
	private ItemPedidoEntityMapper itemPedidoEntityMapper;
	
	public PedidoEntity paraPedidoEntity(Pedido pedido) {
		PedidoEntity pedidoEntity = new PedidoEntity();
		pedidoEntity.setId(pedido.getId());
		pedidoEntity.setCliente(clienteMapper.paraClienteEntity(pedido.getCliente()));
		pedidoEntity.setPrecoTotalPedido(pedido.getPrecoTotalPedido());
		pedidoEntity.setStatus(pedido.getStatus());
		pedidoEntity.setItemsPedido(itemPedidoEntityMapper.paraListaItemPedidoEntity(pedido.getItemsPedido(), pedidoEntity));
		return pedidoEntity;
	}

}
