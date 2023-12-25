package br.com.portsadapters.fastfoodapp.application.ports.in.endereco;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;

public interface BuscarEnderecoPorIdInputPort {
	Optional<EnderecoEntity> buscarPorId(Long id);
}
