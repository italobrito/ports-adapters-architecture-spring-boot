package br.com.portsadapters.fastfoodapp.application.ports.out.lanche;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;

public interface BuscarLanchesOutputport {
	List<LancheEntity> buscarTodos();
}
