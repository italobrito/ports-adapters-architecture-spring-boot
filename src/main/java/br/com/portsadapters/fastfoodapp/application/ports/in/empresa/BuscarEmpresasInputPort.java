package br.com.portsadapters.fastfoodapp.application.ports.in.empresa;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;

public interface BuscarEmpresasInputPort {
	List<EmpresaEntity> buscarTodos();
}
