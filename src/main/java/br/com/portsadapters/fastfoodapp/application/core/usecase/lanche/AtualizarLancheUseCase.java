package br.com.portsadapters.fastfoodapp.application.core.usecase.lanche;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Lanche;
import br.com.portsadapters.fastfoodapp.application.ports.in.lanche.AtualizarLancheInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.lanche.AtualizarLancheOutputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.lanche.BuscarLanchePorIdOutputPort;

public class AtualizarLancheUseCase implements AtualizarLancheInputPort {
	
	private final AtualizarLancheOutputPort atualizarLancheOutputPort;

	private final BuscarLanchePorIdOutputPort buscarLanchePorIdOutputPort;
	
	public AtualizarLancheUseCase(AtualizarLancheOutputPort atualizarLancheOutputPort,
			BuscarLanchePorIdOutputPort buscarLanchePorIdOutputPort) {
		this.atualizarLancheOutputPort = atualizarLancheOutputPort;
		this.buscarLanchePorIdOutputPort = buscarLanchePorIdOutputPort;
	}
	
	@Override
	public LancheEntity atualizar(Lanche Lanche) {
		Optional<LancheEntity> LancheEntity = buscarLanchePorIdOutputPort.buscarPorId(Lanche.getId());
		if (LancheEntity.isEmpty()) {
			throw new RuntimeException("Lanche não encontrado");
		}
		return atualizarLancheOutputPort.atualizar(Lanche);
	}

}
