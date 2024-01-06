package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.PedidoRequest;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;
import org.mapstruct.Mapping;

@Component
@Mapper(componentModel = "spring")
public interface PedidoMapperInterface {
	@Mapping(target = "tipoPagamento", ignore = true)
	Pedido paraPedidoRequest(PedidoRequest pedidoRequest);
}
