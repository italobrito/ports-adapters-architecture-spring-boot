package br.com.portsadapters.fastfoodapp.application.ports.out.cliente;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;

public interface BuscarClientePorIdOutputPort {
	Optional<Cliente> buscarPorId(Long id);
}
