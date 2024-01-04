package br.com.portsadapters.fastfoodapp.adapters.out.pagamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.FormaPagamentoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;
import br.com.portsadapters.fastfoodapp.application.ports.out.pagamento.BuscarFormaPagamentoOutputPort;

@Component
public class BuscarFormaPagamentoAdapter implements BuscarFormaPagamentoOutputPort {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;

	@Override
	public List<FormaPagamentoEntity> buscarTodos() {
		List<FormaPagamentoEntity> formasPagamento = formaPagamentoRepository.findAll();
		return formasPagamento;
	}
}