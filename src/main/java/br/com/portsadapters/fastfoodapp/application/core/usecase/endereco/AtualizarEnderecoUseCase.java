package br.com.portsadapters.fastfoodapp.application.core.usecase.endereco;

import java.util.Optional;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Endereco;
import br.com.portsadapters.fastfoodapp.application.ports.in.endereco.AtualizarEnderecoInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.endereco.AtualizarEnderecoOutputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.endereco.BuscarEnderecoPorIdOutputPort;

public class AtualizarEnderecoUseCase implements AtualizarEnderecoInputPort {

	private final AtualizarEnderecoOutputPort atualizarEnderecoOutputPort;
	private final BuscarEnderecoPorIdOutputPort buscarEnderecoPorIdOutputPort;

	public AtualizarEnderecoUseCase(AtualizarEnderecoOutputPort atualizarEnderecoOutputPort,
			BuscarEnderecoPorIdOutputPort buscarEnderecoPorIdOutputPort) {
		this.atualizarEnderecoOutputPort = atualizarEnderecoOutputPort;
		this.buscarEnderecoPorIdOutputPort = buscarEnderecoPorIdOutputPort;
	}

	@Override
	public EnderecoEntity atualizar(Endereco endereco) {
		Optional<EnderecoEntity> enderecoEntity = buscarEnderecoPorIdOutputPort.buscarPorId(endereco.getId());
		if (enderecoEntity.isEmpty()) {
			throw new RuntimeException("Endereço não encontrado");
		}
		return atualizarEnderecoOutputPort.atualizar(endereco);
	}

}
