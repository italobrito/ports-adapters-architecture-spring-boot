package br.com.portsadapters.fastfoodapp.application.core.usecase.insumo;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.application.ports.in.insumo.BuscarInsumoPorIdInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.insumo.BuscarInsumoPorIdOutputPort;

public class BuscarInsumoPorIdUseCase implements BuscarInsumoPorIdInputPort {
	
	private final BuscarInsumoPorIdOutputPort buscarInsumoPorIdOutputPort;
	
	public BuscarInsumoPorIdUseCase(BuscarInsumoPorIdOutputPort buscarInsumoPorIdOutputPort) {
		this.buscarInsumoPorIdOutputPort = buscarInsumoPorIdOutputPort;
	}
	@Override
	public Optional<InsumoEntity> buscarPorId(Long id) {
		Optional<InsumoEntity> insumo = buscarInsumoPorIdOutputPort.buscarPorId(id);
		if (insumo == null) {
			 throw new RuntimeException("Insumo não encontrado");
		}
		return insumo;
	}

}
