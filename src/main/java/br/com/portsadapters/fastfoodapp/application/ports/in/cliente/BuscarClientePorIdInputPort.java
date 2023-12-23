package br.com.portsadapters.fastfoodapp.application.ports.in.cliente;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;

public interface BuscarClientePorIdInputPort {
	Optional<ClienteEntity> buscarPorId(Long id);
}
