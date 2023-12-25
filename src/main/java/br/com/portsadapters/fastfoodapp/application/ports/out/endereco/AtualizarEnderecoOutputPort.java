package br.com.portsadapters.fastfoodapp.application.ports.out.endereco;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Endereco;

public interface AtualizarEnderecoOutputPort {
	EnderecoEntity atualizar(Endereco endereco);
}
