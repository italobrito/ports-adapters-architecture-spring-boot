package br.com.portsadapters.fastfoodapp.application.ports.out.endereco;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;

public interface BuscarEnderecoPorIdOutputPort {
	Optional<EnderecoEntity> buscarPorId(Long id);
}
