package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.ClienteMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ItemPedidoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.ItemPedido;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;

@Component
public class ItemPedidoEntityMapper {

	@Autowired
	private LancheEntityMapper lancheEntityMapper;

	@Autowired
	private ClienteMapper clienteMapper;

	/*
	 * @Autowired private PedidoEntityMapper pedidoEntityMapper;
	 */

	public PedidoEntity paraPedidoEntity(Pedido pedido) {
		PedidoEntity pedidoEntity = new PedidoEntity();
		pedidoEntity.setId(pedido.getId());
		pedidoEntity.setCliente(clienteMapper.paraClienteEntity(pedido.getCliente()));
		pedidoEntity.setPrecoTotalPedido(pedido.getPrecoTotalPedido());
		pedidoEntity.setStatus(pedido.getStatus());
		pedidoEntity.setItemsPedido(paraItemPedido(pedido.getItemsPedido(), pedido));
		return pedidoEntity;
	}

	public List<ItemPedidoEntity> paraItemPedido(List<ItemPedido> itemsPedido, Pedido pedido) {

		List<ItemPedidoEntity> itemsDoPedido = new ArrayList<>();
		
		PedidoEntity pedidoEntity = new PedidoEntity();
		pedidoEntity.setId(pedido.getId());
		pedidoEntity.setCliente(clienteMapper.paraClienteEntity(pedido.getCliente()));
		pedidoEntity.setPrecoTotalPedido(pedido.getPrecoTotalPedido());
		pedidoEntity.setStatus(pedido.getStatus());

		for (ItemPedido itemPedido : itemsPedido) {

			ItemPedidoEntity itemPedidoCriado = new ItemPedidoEntity();

			itemPedidoCriado.setId(itemPedido.getId());

			itemPedidoCriado.setQuantidade(itemPedido.getQuantidade());

			itemPedidoCriado.setLanches(lancheEntityMapper.paraLancheEntity(itemPedido.getLanches()));
			
			itemPedidoCriado.setPedido(pedidoEntity);
			
			/*
			 * itemPedidoCriado.setNome(itemPedido.getNome());
			 * itemPedidoCriado.setCpfCnpj(itemPedido.getCpfCnpj());
			 */

			itemsDoPedido.add(itemPedidoCriado);

		}

		return itemsDoPedido;
	}

	
	public List<ItemPedidoEntity> paraListaItemPedidoEntity(List<ItemPedido> itemsPedido, PedidoEntity pedidoEntity) {
	    List<ItemPedidoEntity> itemPedidoEntities = new ArrayList<>();

	    for (ItemPedido itemPedido : itemsPedido) {
	        ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();
	        itemPedidoEntity.setPedido(pedidoEntity);
	        itemPedidoEntity.setLanches(lancheEntityMapper.paraLancheEntity(itemPedido.getLanches()));
	        itemPedidoEntity.setQuantidade(itemPedido.getQuantidade());

	        itemPedidoEntities.add(itemPedidoEntity);
	    }

	    return itemPedidoEntities;
	}
	
}
