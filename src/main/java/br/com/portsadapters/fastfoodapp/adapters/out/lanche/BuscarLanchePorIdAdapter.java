package br.com.portsadapters.fastfoodapp.adapters.out.lanche;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.LancheRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.ports.out.lanche.BuscarLanchePorIdOutputPort;

@Component
public class BuscarLanchePorIdAdapter implements BuscarLanchePorIdOutputPort {

	@Autowired
	private LancheRepository lancheRepository;
	
	@Override
	public Optional<LancheEntity> buscarPorId(Long id) {
		LancheEntity lancheEntity = lancheRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("O lanche não foi encontrado com o ID fornecido: " + id));
		return Optional.ofNullable(lancheEntity);
	}

}
