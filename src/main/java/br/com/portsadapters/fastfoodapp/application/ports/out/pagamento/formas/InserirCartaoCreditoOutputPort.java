package br.com.portsadapters.fastfoodapp.application.ports.out.pagamento.formas;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoCreditoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoCredito;

public interface InserirCartaoCreditoOutputPort {
	CartaoCreditoEntity inserir(CartaoCredito cartaoDebito);
}
