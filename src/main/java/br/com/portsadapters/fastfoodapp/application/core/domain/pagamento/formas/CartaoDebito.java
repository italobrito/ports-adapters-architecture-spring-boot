package br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDebito extends Cartao {
	private static final long serialVersionUID = 5181320592674391046L;
	private TipoPagamentoEnum tipoPagamento = TipoPagamentoEnum.CARTAO_DEBITO;
}
