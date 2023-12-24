package br.com.portsadapters.fastfoodapp.application.ports.out.empresa;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;

public interface BuscarEmpresasOutputPort {
	List<EmpresaEntity> buscarTodos();
}
