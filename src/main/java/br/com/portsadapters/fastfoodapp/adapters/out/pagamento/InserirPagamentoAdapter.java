package br.com.portsadapters.fastfoodapp.adapters.out.pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.PagamentoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.PagamentoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.pagamento.PagamentoEntityMapper;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.Pagamento;
import br.com.portsadapters.fastfoodapp.application.ports.out.pagamento.InserirPagamentoOutputPort;

@Component
public class InserirPagamentoAdapter implements InserirPagamentoOutputPort {
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private PagamentoEntityMapper pagamentoMapper;

	@Override
	public PagamentoEntity inserir(Pagamento formaPagamento) {
		PagamentoEntity pagamentoEntity = pagamentoMapper.paraPagamentoEntity(formaPagamento);
		PagamentoEntity formaPagamentoSalvo = pagamentoRepository.save(pagamentoEntity);
		return formaPagamentoSalvo;
	}

}
