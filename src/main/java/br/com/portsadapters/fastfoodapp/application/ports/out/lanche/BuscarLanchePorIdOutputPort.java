package br.com.portsadapters.fastfoodapp.application.ports.out.lanche;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;

public interface BuscarLanchePorIdOutputPort {
	Optional<LancheEntity> buscarPorId(Long id);
}
