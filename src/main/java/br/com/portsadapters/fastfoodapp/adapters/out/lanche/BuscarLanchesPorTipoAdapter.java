package br.com.portsadapters.fastfoodapp.adapters.out.lanche;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoLanche;
import br.com.portsadapters.fastfoodapp.application.ports.out.lanche.BuscarLanchesPorTipoOutputPort;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.LancheRepository;

@Component
public class BuscarLanchesPorTipoAdapter implements BuscarLanchesPorTipoOutputPort {
	
	@Autowired
	private LancheRepository lancheRepository;

	@Override
	public List<LancheEntity> buscarLanchesPorTipo(TipoLanche tipoLanche) {
		return lancheRepository.buscarLanchesPorTipo(tipoLanche.toString());
	}
}
