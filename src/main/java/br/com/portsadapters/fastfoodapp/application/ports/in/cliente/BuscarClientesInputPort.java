package br.com.portsadapters.fastfoodapp.application.ports.in.cliente;

import java.util.List;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;

public interface BuscarClientesInputPort {
	List<Cliente> buscarTodos();
}
