package br.com.portsadapters.fastfoodapp.application.ports.out.empresa;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;

public interface AtualizarEmpresaOutputPort {
	EmpresaEntity atualizar(Empresa empresa);
}
