package br.com.portsadapters.fastfoodapp.adapters.out.pagamento.formas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.formas.CartaoDebitoMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.CartaoDebitoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoDebitoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoDebito;
import br.com.portsadapters.fastfoodapp.application.ports.out.pagamento.formas.InserirCartaoDebitoOutputPort;

@Component
public class InserirCartaoDebitoAdapter implements InserirCartaoDebitoOutputPort {
	
	@Autowired
	private CartaoDebitoMapper cartaoDebitoMapper;
	
	@Autowired
	private CartaoDebitoRepository cartaoDebitoRepository;

	@Override
	public CartaoDebitoEntity inserir(CartaoDebito cartaoDebito) {
		CartaoDebitoEntity cartaoDebitoEntity = cartaoDebitoMapper.paraCartaoDebitoEntity(cartaoDebito);
		CartaoDebitoEntity cartaoDebitoSalvo = cartaoDebitoRepository.save(cartaoDebitoEntity);
		return cartaoDebitoSalvo;
	}

}


/*public class InserirInsumoAdapter implements InserirInsumoOutputPort {
	
	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private InsumoEntityMapper insumoEntityMapper;

	@Override
	public InsumoEntity inserir(Insumo insumo) {
		InsumoEntity insumoEntity = insumoEntityMapper.paraInsumoEntity(insumo);
		InsumoEntity insumoSalvo = insumoRepository.save(insumoEntity);
		insumoEntity.setId(insumoSalvo.getId());
		return insumoEntity;
	}

}*/

