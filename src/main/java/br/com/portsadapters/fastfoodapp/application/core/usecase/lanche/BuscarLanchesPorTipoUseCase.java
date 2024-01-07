package br.com.portsadapters.fastfoodapp.application.core.usecase.lanche;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoLanche;
import br.com.portsadapters.fastfoodapp.application.ports.in.lanche.BuscarLanchesPorTipoInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.lanche.BuscarLanchesPorTipoOutputPort;

public class BuscarLanchesPorTipoUseCase implements BuscarLanchesPorTipoInputPort {

	private final BuscarLanchesPorTipoOutputPort buscarLanchesPorTipoOutputPort;

	public BuscarLanchesPorTipoUseCase(BuscarLanchesPorTipoOutputPort buscarLanchesPorTipoOutputPort) {
		this.buscarLanchesPorTipoOutputPort = buscarLanchesPorTipoOutputPort;
	}

	@Override
	public List<LancheEntity> buscarLanchesPorTipo(TipoLanche tipoLanche) {
		List<LancheEntity> lanches = buscarLanchesPorTipoOutputPort.buscarLanchesPorTipo(tipoLanche);
		return lanches;
	}

}
