package br.com.portsadapters.fastfoodapp.application.ports.in.pagamento.formas;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoDebitoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoDebito;

public interface InserirCartaoDebitoInputPort {
	CartaoDebitoEntity inserir(CartaoDebito cartaoDebito);
}
