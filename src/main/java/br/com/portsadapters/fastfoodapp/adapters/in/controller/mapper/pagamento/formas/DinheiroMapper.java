package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.formas;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.formas.DinheiroRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.DinheiroEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.Dinheiro;

@Component
public class DinheiroMapper {
	public DinheiroEntity paraDinheiroEntity(Dinheiro dinheiro) {
		DinheiroEntity dinheiroEntity = new DinheiroEntity();
		dinheiroEntity.setId(dinheiro.getId());
		dinheiroEntity.setTipoPagamento(dinheiro.getTipoPagamento());
		return dinheiroEntity;
	}
	
	public Dinheiro paraDinheiro(DinheiroRequest dinheiroRequest) {
		Dinheiro dinheiro = new Dinheiro();
		dinheiro.setId(dinheiroRequest.getId());
		dinheiro.setTipoPagamento(dinheiroRequest.getTipoPagamento());
		return dinheiro;
	}
}
