package br.com.portsadapters.fastfoodapp.application.ports.out.cliente;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;

public interface BuscarClientePorIdOutputPort {
	Optional<ClienteEntity> buscarPorId(Long id);
}
