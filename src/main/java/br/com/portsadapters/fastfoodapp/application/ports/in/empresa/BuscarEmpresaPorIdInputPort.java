package br.com.portsadapters.fastfoodapp.application.ports.in.empresa;

import java.util.Optional;
import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa; 

public interface BuscarEmpresaPorIdInputPort {
	Optional<Empresa> buscarPorId(Long id);
}
