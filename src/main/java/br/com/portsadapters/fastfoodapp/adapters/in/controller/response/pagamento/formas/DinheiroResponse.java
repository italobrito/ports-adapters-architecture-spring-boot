package br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento.formas;

import java.io.Serializable;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DinheiroResponse implements Serializable {

	private static final long serialVersionUID = -8280443563023626123L;

	private Long id;
	
	private TipoPagamentoEnum tipoPagamento = TipoPagamentoEnum.DINHEIRO;

}
