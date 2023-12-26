package br.com.portsadapters.fastfoodapp.application.core.usecase.lanche;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.ports.in.insumo.BuscarLanchePorIdInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.lanche.BuscarLanchePorIdOutputPort;

public class BuscarLanchePorIdUseCase implements BuscarLanchePorIdInputPort {

	private final BuscarLanchePorIdOutputPort buscarLanchePorIdOutputPort;
	
	public BuscarLanchePorIdUseCase(BuscarLanchePorIdOutputPort buscarLanchePorIdOutputPort) {
		this.buscarLanchePorIdOutputPort = buscarLanchePorIdOutputPort;
	}
	
	@Override
	public Optional<LancheEntity> buscarPorId(Long id) {
		Optional<LancheEntity> lanche = buscarLanchePorIdOutputPort.buscarPorId(id);
		if (lanche == null) {
			 throw new RuntimeException("Lanche não encontrado");
		}
		return lanche;
	}

}
