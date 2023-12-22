package br.com.portsadapters.fastfoodapp.application.ports.in.empresa;

import java.util.List;

import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;

public interface BuscarEmpresasInputPort {
	List<Empresa> buscarTodos();
}
