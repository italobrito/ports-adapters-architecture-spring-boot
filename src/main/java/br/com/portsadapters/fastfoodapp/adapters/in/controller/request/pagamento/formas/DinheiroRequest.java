package br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.formas;

import java.io.Serializable;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DinheiroRequest implements Serializable {

	private static final long serialVersionUID = 924669733291919767L;

	private Long id;
	
	private TipoPagamentoEnum tipoPagamento = TipoPagamentoEnum.DINHEIRO;

}
