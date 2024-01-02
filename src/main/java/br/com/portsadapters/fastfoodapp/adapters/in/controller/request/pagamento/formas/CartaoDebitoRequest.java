package br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.formas;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartaoDebitoRequest extends CartaoRequest {
	private static final long serialVersionUID = 5181320592674391046L;
	private TipoPagamentoEnum tipoPagamento = TipoPagamentoEnum.CARTAO_DEBITO;
}
