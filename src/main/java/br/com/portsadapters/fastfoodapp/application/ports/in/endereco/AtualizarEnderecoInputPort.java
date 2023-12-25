package br.com.portsadapters.fastfoodapp.application.ports.in.endereco;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Endereco;

public interface AtualizarEnderecoInputPort {
	EnderecoEntity atualizar(Endereco endereco);
}
