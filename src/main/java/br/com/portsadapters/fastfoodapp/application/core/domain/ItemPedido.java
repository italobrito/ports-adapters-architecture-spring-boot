package br.com.portsadapters.fastfoodapp.application.core.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido extends Base implements Serializable {
	
	private static final long serialVersionUID = 6197063393421391633L;

    private Pedido pedido;
    
    private Lanche lanches;
    
    private Integer quantidade;
	
}
