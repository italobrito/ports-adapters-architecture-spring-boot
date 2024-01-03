package br.com.portsadapters.fastfoodapp.application.core.usecase.pagamento;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.FormaPagamento;
import br.com.portsadapters.fastfoodapp.application.ports.in.pagamento.InserirFormaPagamentoInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.pagamento.InserirFormaPagamentoOutputPort;

public class InserirFormaPagamentoUseCase implements InserirFormaPagamentoInputPort {

	private final InserirFormaPagamentoOutputPort inserirFormaPagamentoOutputPort;
	
	public InserirFormaPagamentoUseCase(InserirFormaPagamentoOutputPort inserirFormaPagamentoOutputPort) {
		this.inserirFormaPagamentoOutputPort = inserirFormaPagamentoOutputPort;
	}

	@Override
	public FormaPagamentoEntity inserir(FormaPagamento FormaPagamento) {
		return this.inserirFormaPagamentoOutputPort.inserir(FormaPagamento);
	}

}

