package br.com.portsadapters.fastfoodapp.application.core.usecase.empresa;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.application.ports.in.empresa.BuscarEmpresasInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.empresa.BuscarEmpresasOutputPort;

public class BuscarEmpresasUseCase implements BuscarEmpresasInputPort {
	
	private final BuscarEmpresasOutputPort buscarEmpresasOutputPort;
	
	public BuscarEmpresasUseCase(BuscarEmpresasOutputPort buscarEmpresasOutputPort) {
		this.buscarEmpresasOutputPort = buscarEmpresasOutputPort;
	}

	@Override
	public List<EmpresaEntity> buscarTodos() {
		return this.buscarEmpresasOutputPort.buscarTodos();
	}

}
