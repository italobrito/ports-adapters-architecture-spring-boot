package br.com.portsadapters.fastfoodapp.application.core.usecase.pagamento;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;
import br.com.portsadapters.fastfoodapp.application.ports.in.pagamento.BuscarFormaPagamentoInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.pagamento.BuscarFormaPagamentoOutputPort;

public class BuscarFormaPagamentoUseCase implements BuscarFormaPagamentoInputPort {
	
	private final BuscarFormaPagamentoOutputPort buscarFormaPagamentoOutputPort;
	
	public BuscarFormaPagamentoUseCase( BuscarFormaPagamentoOutputPort buscarFormaPagamentoOutputPort) {
		this.buscarFormaPagamentoOutputPort = buscarFormaPagamentoOutputPort;
	}

	@Override
	public List<FormaPagamentoEntity> buscarTodos() {
		List<FormaPagamentoEntity> formasPagamento = buscarFormaPagamentoOutputPort.buscarTodos();
		return formasPagamento;
	}
	
}
