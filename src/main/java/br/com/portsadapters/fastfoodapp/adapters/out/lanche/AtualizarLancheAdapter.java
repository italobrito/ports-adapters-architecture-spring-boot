package br.com.portsadapters.fastfoodapp.adapters.out.lanche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.LancheMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.LancheRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Lanche;
import br.com.portsadapters.fastfoodapp.application.ports.out.lanche.AtualizarLancheOutputPort;

@Component
public class AtualizarLancheAdapter implements AtualizarLancheOutputPort {

	@Autowired
	private LancheRepository lancheRepository;
	
	@Autowired
	private LancheMapper lancheMapper;
	
	@Override
	public LancheEntity atualizar(Lanche lanche) {
		LancheEntity lancheEntity = lancheMapper.paraLancheEntity(lanche);
		return lancheRepository.save(lancheEntity);
	}

}
