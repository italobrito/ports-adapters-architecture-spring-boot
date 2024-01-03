package br.com.portsadapters.fastfoodapp.adapters.out.pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.FormaPagamentoMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.FormaPagamentoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.FormaPagamento;
import br.com.portsadapters.fastfoodapp.application.ports.out.pagamento.InserirFormaPagamentoOutputPort;

@Component
public class InserirFormaPagamentoAdapter implements InserirFormaPagamentoOutputPort {
	
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@Autowired
	private FormaPagamentoMapper formaPagamentoMapper;

	@Override
	public FormaPagamentoEntity inserir(FormaPagamento formaPagamento) {
		FormaPagamentoEntity formaPagamentoEntity = formaPagamentoMapper.paraFormaPagamentoEntity(formaPagamento);
		FormaPagamentoEntity formaPagamentoSalvo = formaPagamentoRepository.save(formaPagamentoEntity);
		return formaPagamentoSalvo;
	}

}
