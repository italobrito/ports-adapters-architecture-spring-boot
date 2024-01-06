package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;

@Mapper(componentModel = "spring")
public interface PedidoEntityMapperInterface {
	//@Mapping(source = "propriedadeOrigem", target = "propriedadeDestino")
	@Mapping(target = "tipoPagamento", ignore = true)
	public PedidoEntity paraPedidoEntity(Pedido pedido);
}
