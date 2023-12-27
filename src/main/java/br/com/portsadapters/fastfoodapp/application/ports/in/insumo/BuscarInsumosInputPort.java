package br.com.portsadapters.fastfoodapp.application.ports.in.insumo;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;

public interface BuscarInsumosInputPort {
	List<InsumoEntity> buscarTodos();
}
