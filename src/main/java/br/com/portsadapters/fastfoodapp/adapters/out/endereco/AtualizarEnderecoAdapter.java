package br.com.portsadapters.fastfoodapp.adapters.out.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.EnderecoMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.EnderecoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Endereco;
import br.com.portsadapters.fastfoodapp.application.ports.out.endereco.AtualizarEnderecoOutputPort;

@Component
public class AtualizarEnderecoAdapter implements AtualizarEnderecoOutputPort {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EnderecoMapper enderecoMapper;

	@Override
	public EnderecoEntity atualizar(Endereco endereco) {
		EnderecoEntity enderecoEntity = enderecoMapper.paraEnderecoEntity(endereco);
		return enderecoRepository.save(enderecoEntity);
	}

}
