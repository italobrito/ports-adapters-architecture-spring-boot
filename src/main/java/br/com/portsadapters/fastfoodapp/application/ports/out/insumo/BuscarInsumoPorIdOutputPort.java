package br.com.portsadapters.fastfoodapp.application.ports.out.insumo;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;

public interface BuscarInsumoPorIdOutputPort {
	Optional<InsumoEntity> buscarPorId(Long id);
}
