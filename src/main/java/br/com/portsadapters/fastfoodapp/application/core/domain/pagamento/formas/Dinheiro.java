package br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas;

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
public class Dinheiro implements Serializable {

	private static final long serialVersionUID = 5967545852419625718L;

	private Long id;
	
	private TipoPagamentoEnum tipoPagamento = TipoPagamentoEnum.DINHEIRO;

}
