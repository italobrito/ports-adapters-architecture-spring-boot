package br.com.portsadapters.fastfoodapp.application.ports.out.lanche;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Lanche;

public interface InserirLancheOutputPort {
	LancheEntity inserir(Lanche lanche);
}
