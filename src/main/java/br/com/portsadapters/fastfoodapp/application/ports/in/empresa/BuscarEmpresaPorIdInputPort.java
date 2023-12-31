package br.com.portsadapters.fastfoodapp.application.ports.in.empresa;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;

public interface BuscarEmpresaPorIdInputPort {
	Optional<EmpresaEntity> buscarPorId(Long id);
}
