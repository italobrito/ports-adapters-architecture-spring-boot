package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.formas;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.formas.CartaoCreditoRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoCreditoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoCredito;

@Component
public class CartaoCreditoMapper {

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
	
	public CartaoCredito paraCartaoCredito(CartaoCreditoRequest cartaoCreditoRequest) {
		CartaoCredito cartaoCredito = new CartaoCredito();
		cartaoCredito.setApelido(cartaoCreditoRequest.getApelido());
		cartaoCredito.setCpfCnpj(cartaoCreditoRequest.getCpfCnpj());
		cartaoCredito.setCvv(cartaoCreditoRequest.getCvv());
		cartaoCredito.setNomeDoTitular(cartaoCreditoRequest.getNomeDoTitular());
		cartaoCredito.setNumeroCartao(cartaoCreditoRequest.getNumeroCartao());
		cartaoCredito.setValidade(cartaoCreditoRequest.getValidade());
		cartaoCredito.setId(cartaoCreditoRequest.getId());
		cartaoCredito.setTipoPagamento(cartaoCreditoRequest.getTipoPagamento());
		return cartaoCredito;
	}

}
