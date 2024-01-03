package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.pagamento.formas;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.DinheiroEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.Dinheiro;

@Component
public class DinheiroEntityMapper {
	public DinheiroEntity paraDinheiroEntity(Dinheiro dinheiro) {
		DinheiroEntity dinheiroEntity = new DinheiroEntity();
		dinheiroEntity.setId(dinheiro.getId());
		dinheiroEntity.setTipoPagamento(dinheiro.getTipoPagamento());
		return dinheiroEntity;
	}
}
