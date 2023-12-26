package br.com.portsadapters.fastfoodapp.application.ports.in.insumo;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;

public interface BuscarLanchePorIdInputPort {
	Optional<LancheEntity> buscarPorId(Long id);
}
