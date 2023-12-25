package br.com.portsadapters.fastfoodapp.application.core.usecase.insumo;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Insumo;
import br.com.portsadapters.fastfoodapp.application.ports.in.insumo.InserirInsumoInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.insumo.InserirInsumoOutputPort;

public class InserirInsumoUseCase implements InserirInsumoInputPort {

	private final InserirInsumoOutputPort inserirInsumoOutputPort;
	
	public InserirInsumoUseCase(InserirInsumoOutputPort inserirInsumoOutputPort) {
		this.inserirInsumoOutputPort = inserirInsumoOutputPort;
	}
	
	@Override
	public InsumoEntity inserir(Insumo insumo) {
		return this.inserirInsumoOutputPort.inserir(insumo);
	}

}
