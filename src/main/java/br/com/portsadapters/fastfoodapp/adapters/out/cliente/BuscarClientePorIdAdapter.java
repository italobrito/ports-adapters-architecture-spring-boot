package br.com.portsadapters.fastfoodapp.adapters.out.cliente;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.ClienteRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.application.ports.out.cliente.BuscarClientePorIdOutputPort;

@Component
public class BuscarClientePorIdAdapter implements BuscarClientePorIdOutputPort  {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Optional<ClienteEntity> buscarPorId(Long id) {
		ClienteEntity clienteEntity = clienteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID fornecido: " + id));
		return Optional.ofNullable(clienteEntity);
	}
	
}
