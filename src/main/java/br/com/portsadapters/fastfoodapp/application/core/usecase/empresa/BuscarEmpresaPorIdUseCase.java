package br.com.portsadapters.fastfoodapp.application.core.usecase.empresa;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.application.ports.in.empresa.BuscarEmpresaPorIdInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.empresa.BuscarEmpresaPorIdOutputPort;

public class BuscarEmpresaPorIdUseCase implements BuscarEmpresaPorIdInputPort {
	
	private final BuscarEmpresaPorIdOutputPort buscarEmpresaPorIdOutputPort;
	
	public BuscarEmpresaPorIdUseCase(BuscarEmpresaPorIdOutputPort buscarEmpresaPorIdOutputPort) {
		this.buscarEmpresaPorIdOutputPort = buscarEmpresaPorIdOutputPort;
	}

	@Override
	public Optional<EmpresaEntity> buscarPorId(Long id) {
		Optional<EmpresaEntity> empresa = buscarEmpresaPorIdOutputPort.buscarPorId(id);
		if (empresa == null) {
			 throw new RuntimeException("Empresa não encontrada");
		}
		return empresa;
	}

}
