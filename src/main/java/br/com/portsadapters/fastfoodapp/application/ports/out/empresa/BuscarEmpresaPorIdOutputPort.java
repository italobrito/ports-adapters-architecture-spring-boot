package br.com.portsadapters.fastfoodapp.application.ports.out.empresa;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;

public interface BuscarEmpresaPorIdOutputPort {
	Optional<EmpresaEntity> buscarPorId(Long id);
}
