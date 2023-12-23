package br.com.portsadapters.fastfoodapp.application.ports.in.cliente;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;

public interface BuscarClientesInputPort {
	List<ClienteEntity> buscarTodos();
}
