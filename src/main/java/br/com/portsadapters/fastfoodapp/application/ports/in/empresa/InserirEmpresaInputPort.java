package br.com.portsadapters.fastfoodapp.application.ports.in.empresa;

import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;

public interface InserirEmpresaInputPort {
	void inserir(Empresa empresa);
}
