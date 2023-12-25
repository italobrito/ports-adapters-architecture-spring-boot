package br.com.portsadapters.fastfoodapp.application.ports.in.lanche;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Lanche;

public interface InserirLancheInputPort {
	LancheEntity inserir(Lanche lanche);
}
