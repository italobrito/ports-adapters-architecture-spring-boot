package br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDebitoEntity extends CartaoEntity {
	private static final long serialVersionUID = -1611889583672270920L;
	private TipoPagamentoEnum tipoPagamento = TipoPagamentoEnum.CARTAO_DEBITO;
}
