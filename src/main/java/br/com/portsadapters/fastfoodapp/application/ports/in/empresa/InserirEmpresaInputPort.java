package br.com.portsadapters.fastfoodapp.application.ports.in.empresa;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;

public interface InserirEmpresaInputPort {
	EmpresaEntity inserir(Empresa empresa);
}
