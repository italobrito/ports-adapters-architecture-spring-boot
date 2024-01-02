package br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento.formas;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartaoCreditoResponse extends CartaoResponse {
	private static final long serialVersionUID = 6256209862704734082L;
	private TipoPagamentoEnum tipoPagamento = TipoPagamentoEnum.CARTAO_CREDITO;
}
