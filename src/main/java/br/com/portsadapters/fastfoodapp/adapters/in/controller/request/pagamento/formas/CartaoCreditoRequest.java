package br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.formas;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartaoCreditoRequest extends CartaoRequest {
	private static final long serialVersionUID = -7621518983255440762L;
	private TipoPagamentoEnum tipoPagamento = TipoPagamentoEnum.CARTAO_CREDITO;
}
