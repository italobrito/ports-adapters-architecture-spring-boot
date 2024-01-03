package br.com.portsadapters.fastfoodapp.application.ports.in.pagamento.formas;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoCreditoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoCredito;

public interface InserirCartaoCreditoInputPort {
	CartaoCreditoEntity inserir(CartaoCredito cartaoCredito);
}
