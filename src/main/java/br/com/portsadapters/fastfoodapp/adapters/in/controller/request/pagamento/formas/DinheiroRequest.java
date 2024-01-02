package br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.formas;

import java.io.Serializable;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DinheiroRequest implements Serializable {

	private static final long serialVersionUID = 5967545852419625718L;

	private Long id;
	
	private TipoPagamentoEnum tipoPagamento = TipoPagamentoEnum.DINHEIRO;

}
