package br.com.portsadapters.fastfoodapp.application.ports.out.insumo;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;

public interface BuscarInsumosOutputPort {
	List<InsumoEntity> buscarTodos();
}
