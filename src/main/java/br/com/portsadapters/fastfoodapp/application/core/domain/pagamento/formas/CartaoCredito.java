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
public class CartaoCredito extends Cartao {
	private static final long serialVersionUID = 1701500130294246232L;
	private TipoPagamentoEnum tipoPagamento = TipoPagamentoEnum.CARTAO_CREDITO;
}
