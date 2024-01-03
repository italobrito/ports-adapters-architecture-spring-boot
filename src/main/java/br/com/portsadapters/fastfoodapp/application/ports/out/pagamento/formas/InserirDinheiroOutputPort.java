package br.com.portsadapters.fastfoodapp.application.ports.out.pagamento.formas;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.DinheiroEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.Dinheiro;

public interface InserirDinheiroOutputPort {
	DinheiroEntity inserir(Dinheiro dinheiro);
}
