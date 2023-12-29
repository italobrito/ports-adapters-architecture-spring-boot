package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.PedidoRequest;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;

@Component
public class PedidoMapper {
	
	@Autowired 
	private ClienteMapper clienteMapper;
	
	@Autowired
	private ItemPedidoMapper itemPedidoMapper;
	
	public Pedido paraPedido(PedidoRequest pedidoRequest) {
		Pedido pedido = new Pedido();
		pedido.setId(pedidoRequest.getId());
		pedido.setCliente(clienteMapper.paraCliente(pedidoRequest.getCliente()));
		pedido.setPrecoTotalPedido(pedidoRequest.getPrecoTotalPedido());
		pedido.setStatus(pedidoRequest.getStatus());
		pedido.setItemsPedido(itemPedidoMapper.paraItemPedido(pedidoRequest.getItemsPedido(), pedido));
		return pedido;
	}

}
