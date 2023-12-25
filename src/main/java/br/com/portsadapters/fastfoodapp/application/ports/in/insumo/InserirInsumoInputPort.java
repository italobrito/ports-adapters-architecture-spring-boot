package br.com.portsadapters.fastfoodapp.application.ports.in.insumo;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Insumo;

public interface InserirInsumoInputPort {
	InsumoEntity inserir(Insumo insumo);
}
