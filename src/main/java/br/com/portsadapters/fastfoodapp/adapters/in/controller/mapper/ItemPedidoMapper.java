package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.ItemPedidoRequest;
import br.com.portsadapters.fastfoodapp.application.core.domain.ItemPedido;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;

@Component
public class ItemPedidoMapper {
	
	@Autowired
	private LancheMapper lancheMapper;
	
	public List<ItemPedido> paraItemPedido(List<ItemPedidoRequest> itemsPedidoRequest, Pedido pedido) {
		
		List<ItemPedido> itemsPedido = new ArrayList<>();
		
        for (ItemPedidoRequest itemPedidoRequest : itemsPedidoRequest) {
        	
        	ItemPedido itemPedidoCriado = new ItemPedido();
        	
        	itemPedidoCriado.setId(itemPedidoRequest.getId());
        	
        	itemPedidoCriado.setPedido(pedido);
        	
        	itemPedidoCriado.setQuantidade(itemPedidoRequest.getQuantidade());
        	
        	itemPedidoCriado.setLanches(lancheMapper.paraLanche(itemPedidoRequest.getLanches()));
			/*
			 * itemPedidoCriado.setNome(itemPedido.getNome());
			 * itemPedidoCriado.setCpfCnpj(itemPedido.getCpfCnpj());
			 */
            
        	itemsPedido.add(itemPedidoCriado);
            
        }

		return itemsPedido;
	}

}
