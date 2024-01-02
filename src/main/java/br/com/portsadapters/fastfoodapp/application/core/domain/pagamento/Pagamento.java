package br.com.portsadapters.fastfoodapp.application.core.domain.pagamento;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.Cartao;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.Dinheiro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento implements Serializable {

	private static final long serialVersionUID = -1595669632116857366L;

	private Long id;
	
	private BigDecimal valorDaCompra;
	
	private Cartao cartao;
	
	private Dinheiro dinheiro;
	
	private TipoPagamentoEnum tipoPagamento;
	
    private Cliente cliente;

}

