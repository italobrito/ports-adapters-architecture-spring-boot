package br.com.portsadapters.fastfoodapp.application.core.usecase.empresa;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;
import br.com.portsadapters.fastfoodapp.application.ports.in.empresa.AtualizarEmpresaInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.empresa.AtualizarEmpresaOutputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.empresa.BuscarEmpresaPorIdOutputPort;

public class AtualizarEmpresaUseCase implements AtualizarEmpresaInputPort  {
	
	private final AtualizarEmpresaOutputPort atualizarEmpresaOutputPort;

	private final BuscarEmpresaPorIdOutputPort buscarEmpresaPorIdOutputPort;

	public AtualizarEmpresaUseCase(AtualizarEmpresaOutputPort atualizarEmpresaOutputPort,
			BuscarEmpresaPorIdOutputPort buscarEmpresaPorIdOutputPort) {
		this.atualizarEmpresaOutputPort = atualizarEmpresaOutputPort;
		this.buscarEmpresaPorIdOutputPort = buscarEmpresaPorIdOutputPort;
	}

	@Override
	public EmpresaEntity atualizar(Empresa empresa) {
		Optional<EmpresaEntity> empresaEntity = buscarEmpresaPorIdOutputPort.buscarPorId(empresa.getId());
		if (empresaEntity.isEmpty()) {
			throw new RuntimeException("Empresa não encontrado");
		}
		return atualizarEmpresaOutputPort.atualizar(empresa);
	}

}
