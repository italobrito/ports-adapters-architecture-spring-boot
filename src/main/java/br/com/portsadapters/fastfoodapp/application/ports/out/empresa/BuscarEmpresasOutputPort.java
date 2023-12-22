package br.com.portsadapters.fastfoodapp.application.ports.out.empresa;

import java.util.List;

import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;

public interface BuscarEmpresasOutputPort {
	List<Empresa> buscarTodos();
}
