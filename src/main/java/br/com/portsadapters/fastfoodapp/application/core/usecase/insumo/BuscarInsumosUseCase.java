package br.com.portsadapters.fastfoodapp.application.core.usecase.insumo;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.application.ports.in.insumo.BuscarInsumosInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.insumo.BuscarInsumosOutputPort;

public class BuscarInsumosUseCase implements BuscarInsumosInputPort {
	
	private final BuscarInsumosOutputPort buscarInsumosOutputPort;
	
	public BuscarInsumosUseCase(BuscarInsumosOutputPort buscarInsumosOutputPort) {
		this.buscarInsumosOutputPort = buscarInsumosOutputPort;
	}
	@Override
	public List<InsumoEntity> buscarTodos() {
		List<InsumoEntity> insumos = buscarInsumosOutputPort.buscarTodos();
		return insumos;
	}

}
