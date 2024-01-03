package br.com.portsadapters.fastfoodapp.adapters.out.pagamento.formas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.formas.CartaoCreditoMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.CartaoCreditoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoCreditoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoCredito;
import br.com.portsadapters.fastfoodapp.application.ports.out.pagamento.formas.InserirCartaoCreditoOutputPort;

@Component
public class InserirCartaoCreditoAdapter implements InserirCartaoCreditoOutputPort {
	
	@Autowired
	private CartaoCreditoMapper cartaoCreditoMapper;
	
	@Autowired
	private CartaoCreditoRepository cartaoCreditoRepository;

	@Override
	public CartaoCreditoEntity inserir(CartaoCredito cartaoCredito) {
		CartaoCreditoEntity cartaoCreditoEntity = cartaoCreditoMapper.paraCartaoCreditoEntity(cartaoCredito);
		CartaoCreditoEntity cartaoCreditoSalvo = cartaoCreditoRepository.save(cartaoCreditoEntity);
		return cartaoCreditoSalvo;
	}

}
