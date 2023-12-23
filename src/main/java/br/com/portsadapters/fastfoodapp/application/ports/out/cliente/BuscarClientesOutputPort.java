package br.com.portsadapters.fastfoodapp.application.ports.out.cliente;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;

public interface BuscarClientesOutputPort {
	List<ClienteEntity> buscarTodos();
}
