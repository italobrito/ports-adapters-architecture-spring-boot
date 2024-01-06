package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.ClienteMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.PagamentoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.pagamento.FormaPagamentoEntityMapper;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;

@Component
public class PedidoEntityMapper {
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	@Autowired
	private ItemPedidoEntityMapper itemPedidoEntityMapper;
	
	@Autowired
	private FormaPagamentoEntityMapper formaPagamentoEntityMapper;
	
	public PedidoEntity paraPedidoEntity(Pedido pedido) {
		PedidoEntity pedidoEntity = new PedidoEntity();
		if (pedido.getId() != null) {
			pedidoEntity.setId(pedido.getId());
		}
		pedidoEntity.setCliente(clienteMapper.paraClienteEntity(pedido.getCliente()));
		pedidoEntity.setPrecoTotalPedido(pedido.getPrecoTotalPedido());
		pedidoEntity.setStatus(pedido.getStatus());
		pedidoEntity.setItemsPedido(itemPedidoEntityMapper.paraListaItemPedidoEntity(pedido.getItemsPedido(), pedidoEntity));
		
		PagamentoEntity pagamentoEntity = new PagamentoEntity();
		
		pagamentoEntity.setId(pedido.getPagamento().getId());
		pagamentoEntity.setValorTotal(pedido.getPagamento().getValorTotal());
		
		pagamentoEntity.setFormaPagamento(formaPagamentoEntityMapper.paraFormaPagamentoEntity(pedido.getPagamento().getFormaPagamento()));
		
		pedidoEntity.setPagamento(pagamentoEntity);
		
		return pedidoEntity;
	}

}
