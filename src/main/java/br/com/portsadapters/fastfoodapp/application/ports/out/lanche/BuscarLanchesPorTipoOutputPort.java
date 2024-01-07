package br.com.portsadapters.fastfoodapp.application.ports.out.lanche;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoLanche;

public interface BuscarLanchesPorTipoOutputPort {
	List<LancheEntity> buscarLanchesPorTipo(TipoLanche tipoLanche);
}
