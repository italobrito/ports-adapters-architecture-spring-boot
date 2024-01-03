package br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoResponse implements Serializable {

	private static final long serialVersionUID = 2280474954665061329L;

	private FormaPagamentoResponse formaPagamento;
	
	private BigDecimal valorTotal;
    
}

