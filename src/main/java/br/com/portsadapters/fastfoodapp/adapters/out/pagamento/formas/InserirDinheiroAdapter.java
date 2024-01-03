package br.com.portsadapters.fastfoodapp.adapters.out.pagamento.formas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.formas.DinheiroMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.DinheiroRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.DinheiroEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.Dinheiro;
import br.com.portsadapters.fastfoodapp.application.ports.out.pagamento.formas.InserirDinheiroOutputPort;

@Component
public class InserirDinheiroAdapter implements InserirDinheiroOutputPort {
	
	@Autowired
	private DinheiroMapper dinheiroMapper;
	
	@Autowired
	private DinheiroRepository dinheiroRepository;

	@Override
	public DinheiroEntity inserir(Dinheiro Dinheiro) {
		DinheiroEntity dinheiroEntity = dinheiroMapper.paraDinheiroEntity(Dinheiro);
		DinheiroEntity dinheiroSalvo = dinheiroRepository.save(dinheiroEntity);
		return dinheiroSalvo;
	}

}
