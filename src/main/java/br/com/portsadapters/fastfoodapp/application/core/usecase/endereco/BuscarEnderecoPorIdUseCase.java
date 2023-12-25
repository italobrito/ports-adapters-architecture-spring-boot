package br.com.portsadapters.fastfoodapp.application.core.usecase.endereco;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;
import br.com.portsadapters.fastfoodapp.application.ports.in.endereco.BuscarEnderecoPorIdInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.endereco.BuscarEnderecoPorIdOutputPort;

public class BuscarEnderecoPorIdUseCase implements BuscarEnderecoPorIdInputPort {
	
	private final BuscarEnderecoPorIdOutputPort buscarEnderecoPorIdOutputPort;
	
	public BuscarEnderecoPorIdUseCase(BuscarEnderecoPorIdOutputPort buscarEnderecoPorIdOutputPort) {
		this.buscarEnderecoPorIdOutputPort = buscarEnderecoPorIdOutputPort;
	}

	@Override
	public Optional<EnderecoEntity> buscarPorId(Long id) {
		Optional<EnderecoEntity> endereco = buscarEnderecoPorIdOutputPort.buscarPorId(id);
		if (endereco == null) {
			 throw new RuntimeException("Endereço não encontrado");
		}
		return endereco;
	}

}
