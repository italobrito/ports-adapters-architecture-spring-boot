package br.com.portsadapters.fastfoodapp.adapters.out.insumo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.InsumoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.application.ports.out.insumo.BuscarInsumoPorIdOutputPort;

@Component
public class BuscarInsumoPorIdAdapter implements BuscarInsumoPorIdOutputPort {

	@Autowired
	private InsumoRepository insumoRepository;
	
	@Override
	public Optional<InsumoEntity> buscarPorId(Long id) {
		InsumoEntity insumoEntity = insumoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("O insumo não foi encontrado com o ID fornecido: " + id));
		return Optional.ofNullable(insumoEntity);
	}

}
