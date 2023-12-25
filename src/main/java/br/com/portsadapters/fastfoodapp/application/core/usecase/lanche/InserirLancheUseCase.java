package br.com.portsadapters.fastfoodapp.application.core.usecase.lanche;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Lanche;
import br.com.portsadapters.fastfoodapp.application.ports.in.lanche.InserirLancheInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.lanche.InserirLancheOutputPort;

public class InserirLancheUseCase implements InserirLancheInputPort {

	private final InserirLancheOutputPort inserirLancheOutputPort;
	
	public InserirLancheUseCase(InserirLancheOutputPort inserirLancheOutputPort) {
		this.inserirLancheOutputPort = inserirLancheOutputPort;
	}
	
	@Override
	public LancheEntity inserir(Lanche lanche) {
		return this.inserirLancheOutputPort.inserir(lanche);
	}	
	
}
