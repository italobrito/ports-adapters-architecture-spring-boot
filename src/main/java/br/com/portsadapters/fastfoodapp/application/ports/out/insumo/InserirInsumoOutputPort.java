package br.com.portsadapters.fastfoodapp.application.ports.out.insumo;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Insumo;

public interface InserirInsumoOutputPort {
	InsumoEntity inserir(Insumo insumo);
}
