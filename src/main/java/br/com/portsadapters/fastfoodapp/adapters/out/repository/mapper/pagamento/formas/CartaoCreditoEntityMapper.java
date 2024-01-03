package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.pagamento.formas;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoCreditoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoCredito;

@Component
public class CartaoCreditoEntityMapper {

	public CartaoCreditoEntity paraCartaoCreditoEntity(CartaoCredito cartaoCredito) {
		CartaoCreditoEntity cartaoCreditoEntity = new CartaoCreditoEntity();
		cartaoCreditoEntity.setApelido(cartaoCredito.getApelido());
		cartaoCreditoEntity.setCpfCnpj(cartaoCredito.getCpfCnpj());
		cartaoCreditoEntity.setCvv(cartaoCredito.getCvv());
		cartaoCreditoEntity.setNomeDoTitular(cartaoCredito.getNomeDoTitular());
		cartaoCreditoEntity.setNumeroCartao(cartaoCredito.getNumeroCartao());
		cartaoCreditoEntity.setValidade(cartaoCredito.getValidade());
		cartaoCreditoEntity.setId(cartaoCredito.getId());
		cartaoCreditoEntity.setTipoPagamento(cartaoCredito.getTipoPagamento());
		return cartaoCreditoEntity;
	}

}
