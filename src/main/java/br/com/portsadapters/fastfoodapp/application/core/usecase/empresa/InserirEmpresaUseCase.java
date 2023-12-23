package br.com.portsadapters.fastfoodapp.application.core.usecase.empresa;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;
import br.com.portsadapters.fastfoodapp.application.ports.in.empresa.InserirEmpresaInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.empresa.InserirEmpresaOutputPort;

public class InserirEmpresaUseCase implements InserirEmpresaInputPort {
	
	private final InserirEmpresaOutputPort inserirEmpresaOutputPort;
	
	public InserirEmpresaUseCase(InserirEmpresaOutputPort inserirEmpresaOutputPort) {
		this.inserirEmpresaOutputPort = inserirEmpresaOutputPort;
	}

	@Override
	public EmpresaEntity inserir(Empresa empresa) {
		return this.inserirEmpresaOutputPort.inserir(empresa);
	}

}


