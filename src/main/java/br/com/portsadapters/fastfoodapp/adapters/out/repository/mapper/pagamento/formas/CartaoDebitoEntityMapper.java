package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.pagamento.formas;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoDebitoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoDebito;

@Component
public class CartaoDebitoEntityMapper {

	public CartaoDebitoEntity paraCartaoDebitoEntity(CartaoDebito cartaoDebito) {
		CartaoDebitoEntity cartaoDebitoEntity = new CartaoDebitoEntity();
		cartaoDebitoEntity.setApelido(cartaoDebito.getApelido());
		cartaoDebitoEntity.setCpfCnpj(cartaoDebito.getCpfCnpj());
		cartaoDebitoEntity.setCvv(cartaoDebito.getCvv());
		cartaoDebitoEntity.setNomeDoTitular(cartaoDebito.getNomeDoTitular());
		cartaoDebitoEntity.setNumeroCartao(cartaoDebito.getNumeroCartao());
		cartaoDebitoEntity.setValidade(cartaoDebito.getValidade());
		cartaoDebitoEntity.setId(cartaoDebito.getId());
		cartaoDebitoEntity.setTipoPagamento(cartaoDebito.getTipoPagamento());
		return cartaoDebitoEntity;
	}
}
