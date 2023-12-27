package br.com.portsadapters.fastfoodapp.application.core.usecase.insumo;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Insumo;
import br.com.portsadapters.fastfoodapp.application.ports.in.insumo.AtualizarInsumoInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.insumo.AtualizarInsumoOutputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.insumo.BuscarInsumoPorIdOutputPort;

public class AtualizarInsumoUseCase implements AtualizarInsumoInputPort {
	private final AtualizarInsumoOutputPort atualizarInsumoOutputPort;

	private final BuscarInsumoPorIdOutputPort buscarInsumoPorIdOutputPort;

	public AtualizarInsumoUseCase(AtualizarInsumoOutputPort atualizarInsumoOutputPort,
			BuscarInsumoPorIdOutputPort buscarInsumoPorIdOutputPort) {
		this.atualizarInsumoOutputPort = atualizarInsumoOutputPort;
		this.buscarInsumoPorIdOutputPort = buscarInsumoPorIdOutputPort;
	}

	@Override
	public InsumoEntity atualizar(Insumo insumo) {
		Optional<InsumoEntity> insumoEntity = buscarInsumoPorIdOutputPort.buscarPorId(insumo.getId());
		if (insumoEntity.isEmpty()) {
			throw new RuntimeException("Insumo não encontrado");
		}
		return atualizarInsumoOutputPort.atualizar(insumo);
	}
}
