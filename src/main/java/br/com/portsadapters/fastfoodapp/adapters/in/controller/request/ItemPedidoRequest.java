package br.com.portsadapters.fastfoodapp.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoRequest extends BaseRequest {

    private PedidoRequest pedido;
    
	@NotBlank
    private LancheRequest lanches;
    
    private Integer quantidade;
}
