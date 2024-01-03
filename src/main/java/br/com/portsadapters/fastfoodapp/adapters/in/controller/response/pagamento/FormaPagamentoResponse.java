package br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento;

import java.io.Serializable;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.ClienteResponse;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.PedidoResponse;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento.formas.CartaoCreditoResponse;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento.formas.CartaoDebitoResponse;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento.formas.DinheiroResponse;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormaPagamentoResponse implements Serializable {

	private static final long serialVersionUID = -6415938145701812283L;

	private Long id;
	
    private CartaoDebitoResponse cartaoDebito;
    
    private CartaoCreditoResponse cartaoCredito;
	
	private DinheiroResponse dinheiro;
	
	private TipoPagamentoEnum tipoPagamento;
	
    private ClienteResponse cliente;

    private PedidoResponse pedido;
	
}

