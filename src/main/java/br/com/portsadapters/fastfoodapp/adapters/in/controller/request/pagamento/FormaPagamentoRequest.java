package br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento;

import java.io.Serializable;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.ClienteRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.PedidoRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.formas.CartaoCreditoRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.formas.CartaoDebitoRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.formas.DinheiroRequest;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormaPagamentoRequest implements Serializable {

	private static final long serialVersionUID = -2675944337371186808L;

	private Long id;
	
    private CartaoDebitoRequest cartaoDebito;
    
    private CartaoCreditoRequest cartaoCredito;
	
	private DinheiroRequest dinheiro;
	
	private TipoPagamentoEnum tipoPagamento;
	
    private ClienteRequest cliente;

    private PedidoRequest pedido;
	
}

