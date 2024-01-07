package br.com.portsadapters.fastfoodapp.application.ports.in.lanche;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoLanche;

public interface BuscarLanchesPorTipoInputPort {
	List<LancheEntity> buscarLanchesPorTipo(TipoLanche tipoLanche);
}
