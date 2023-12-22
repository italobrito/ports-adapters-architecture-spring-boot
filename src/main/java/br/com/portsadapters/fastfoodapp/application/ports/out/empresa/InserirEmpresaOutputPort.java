package br.com.portsadapters.fastfoodapp.application.ports.out.empresa;

import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;

public interface InserirEmpresaOutputPort {
	void inserir(Empresa empresa);
}
