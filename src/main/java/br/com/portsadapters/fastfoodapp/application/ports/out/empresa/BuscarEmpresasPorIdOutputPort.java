package br.com.portsadapters.fastfoodapp.application.ports.out.empresa;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;

public interface BuscarEmpresasPorIdOutputPort {
	Optional<Empresa> buscarPorId(Long id);
}
