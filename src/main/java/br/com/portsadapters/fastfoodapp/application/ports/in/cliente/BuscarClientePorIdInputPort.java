package br.com.portsadapters.fastfoodapp.application.ports.in.cliente;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;

public interface BuscarClientePorIdInputPort {
	Optional<Cliente> buscarPorId(Long id);
}
