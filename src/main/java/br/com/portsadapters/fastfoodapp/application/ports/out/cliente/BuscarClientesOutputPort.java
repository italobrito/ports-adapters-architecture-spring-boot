package br.com.portsadapters.fastfoodapp.application.ports.out.cliente;

import java.util.List;

import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;

public interface BuscarClientesOutputPort {
	List<Cliente> buscarTodos();
}
