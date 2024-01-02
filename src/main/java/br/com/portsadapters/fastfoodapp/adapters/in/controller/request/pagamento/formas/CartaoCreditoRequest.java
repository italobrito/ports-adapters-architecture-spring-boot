package br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.formas;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartaoCreditoRequest extends CartaoRequest {
	private static final long serialVersionUID = 1701500130294246232L;
	private TipoPagamentoEnum tipoPagamento = TipoPagamentoEnum.CARTAO_CREDITO;
}
