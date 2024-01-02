package br.com.portsadapters.fastfoodapp.adapters.in.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoResponse extends BaseResponse {

    private PedidoResponse pedido;
    
    private LancheResponse lanches;
    
    private Integer quantidade;
}
