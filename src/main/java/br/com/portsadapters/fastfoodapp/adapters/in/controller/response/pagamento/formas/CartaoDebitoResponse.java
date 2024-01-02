package br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento.formas;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartaoDebitoResponse extends CartaoResponse {
	private static final long serialVersionUID = -8003208935557247031L;
	private TipoPagamentoEnum tipoPagamento = TipoPagamentoEnum.CARTAO_DEBITO;
}
