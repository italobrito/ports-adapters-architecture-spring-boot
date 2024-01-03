package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.formas;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.formas.CartaoDebitoRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoDebitoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoDebito;

@Component
public class CartaoDebitoMapper {

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
	
	public CartaoDebito paraCartaoDebito(CartaoDebitoRequest cartaoDebitoRequest) {
		CartaoDebito cartaoDebito = new CartaoDebito();
		cartaoDebito.setApelido(cartaoDebitoRequest.getApelido());
		cartaoDebito.setCpfCnpj(cartaoDebitoRequest.getCpfCnpj());
		cartaoDebito.setCvv(cartaoDebitoRequest.getCvv());
		cartaoDebito.setNomeDoTitular(cartaoDebitoRequest.getNomeDoTitular());
		cartaoDebito.setNumeroCartao(cartaoDebitoRequest.getNumeroCartao());
		cartaoDebito.setValidade(cartaoDebitoRequest.getValidade());
		cartaoDebito.setId(cartaoDebitoRequest.getId());
		cartaoDebito.setTipoPagamento(cartaoDebitoRequest.getTipoPagamento());
		return cartaoDebito;
	}

}
