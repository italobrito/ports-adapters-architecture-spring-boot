package br.com.portsadapters.fastfoodapp.application.ports.in.insumo;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;

public interface BuscarInsumoPorIdInputPort {
	Optional<InsumoEntity> buscarPorId(Long id);
}
