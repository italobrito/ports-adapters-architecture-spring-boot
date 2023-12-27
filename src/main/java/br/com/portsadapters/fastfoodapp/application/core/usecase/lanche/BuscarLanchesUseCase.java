package br.com.portsadapters.fastfoodapp.application.core.usecase.lanche;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.ports.in.lanche.BuscarLanchesInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.lanche.BuscarLanchesOutputport;

public class BuscarLanchesUseCase implements BuscarLanchesInputPort {

	private final BuscarLanchesOutputport buscarLanchesOutputPort;
	
	public BuscarLanchesUseCase(BuscarLanchesOutputport buscarLanchesOutputPort) {
		this.buscarLanchesOutputPort = buscarLanchesOutputPort;
	}
	
	@Override
	public List<LancheEntity> buscarTodos() {
		List<LancheEntity> lanches = buscarLanchesOutputPort.buscarTodos();
		return lanches;
	}

}
