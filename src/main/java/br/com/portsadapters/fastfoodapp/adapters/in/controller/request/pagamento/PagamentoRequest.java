package br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento;

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
public class PagamentoRequest implements Serializable {

	private static final long serialVersionUID = 7827904857260165179L;
	
	private long id;

	private FormaPagamentoRequest formaPagamento;
	
	private BigDecimal valorTotal;

}
