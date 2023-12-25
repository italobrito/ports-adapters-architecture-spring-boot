package br.com.portsadapters.fastfoodapp.adapters.out.lanche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.LancheRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.LancheEntityMapper;
import br.com.portsadapters.fastfoodapp.application.core.domain.Lanche;
import br.com.portsadapters.fastfoodapp.application.ports.out.lanche.InserirLancheOutputPort;

@Component
public class InserirLancheAdapter implements InserirLancheOutputPort {
	
	@Autowired
	private LancheRepository lancheRepository;
	
	@Autowired
	private LancheEntityMapper lancheEntityMapper;

	@Override
	public LancheEntity inserir(Lanche lanche) {
		LancheEntity lancheEntity = lancheEntityMapper.paraLancheEntity(lanche);
		LancheEntity lancheSalvo = lancheRepository.save(lancheEntity);
		lancheEntity.setId(lancheSalvo.getId());
		return lancheEntity;
	}

}
