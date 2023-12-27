package br.com.portsadapters.fastfoodapp.application.ports.in.lanche;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;

public interface BuscarLanchesInputPort {
	List<LancheEntity> buscarTodos();
}