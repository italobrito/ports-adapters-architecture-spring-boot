package br.com.portsadapters.fastfoodapp.application.core.domain.pagamento;

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
public class Pagamento implements Serializable {

	private static final long serialVersionUID = 1587621544027982592L;
	
	private Long id;

	private FormaPagamento formaPagamento;

	private BigDecimal valorTotal;
}
