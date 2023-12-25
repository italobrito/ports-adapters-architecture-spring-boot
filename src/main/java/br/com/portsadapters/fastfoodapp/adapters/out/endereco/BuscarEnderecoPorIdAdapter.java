package br.com.portsadapters.fastfoodapp.adapters.out.endereco;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.EnderecoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;
import br.com.portsadapters.fastfoodapp.application.ports.out.endereco.BuscarEnderecoPorIdOutputPort;

@Component
public class BuscarEnderecoPorIdAdapter implements BuscarEnderecoPorIdOutputPort {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Optional<EnderecoEntity> buscarPorId(Long id) {
		EnderecoEntity enderecoEntity = enderecoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Endereço não encontrado com o ID fornecido: " + id));
		return Optional.ofNullable(enderecoEntity);
	}

}
