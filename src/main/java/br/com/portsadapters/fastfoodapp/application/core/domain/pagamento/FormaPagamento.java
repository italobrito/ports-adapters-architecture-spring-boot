package br.com.portsadapters.fastfoodapp.application.core.domain.pagamento;

import java.io.Serializable;

import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoCredito;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoDebito;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.Dinheiro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormaPagamento implements Serializable {

	private static final long serialVersionUID = -1595669632116857366L;

	private Long id;
	
    private CartaoDebito cartaoDebito;
    
    private CartaoCredito cartaoCredito;
	
	private Dinheiro dinheiro;
	
	private TipoPagamentoEnum tipoPagamento;
	
    private Cliente cliente;
    
    private Pedido pedido;

}

