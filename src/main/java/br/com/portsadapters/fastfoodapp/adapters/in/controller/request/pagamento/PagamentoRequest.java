package br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento;

import java.io.Serializable;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.ClienteRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.PedidoRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.formas.CartaoRequest;
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
public class PagamentoRequest implements Serializable {

	private static final long serialVersionUID = -1595669632116857366L;

	private Long id;
	
	private CartaoRequest cartao;
	
	private DinheiroRequest dinheiro;
	
	private TipoPagamentoEnum tipoPagamento;
	
	private ClienteRequest cliente;
	
	private PedidoRequest pedido;
    
}

