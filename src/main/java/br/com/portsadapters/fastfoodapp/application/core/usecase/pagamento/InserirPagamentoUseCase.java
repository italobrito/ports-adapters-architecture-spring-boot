package br.com.portsadapters.fastfoodapp.application.core.usecase.pagamento;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.PagamentoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.Pagamento;
import br.com.portsadapters.fastfoodapp.application.ports.in.pagamento.InserirPagamentoInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.pagamento.InserirPagamentoOutputPort;

public class InserirPagamentoUseCase implements InserirPagamentoInputPort {

	private final InserirPagamentoOutputPort inserirPagamentoOutputPort;
	
	public InserirPagamentoUseCase(InserirPagamentoOutputPort inserirPagamentoOutputPort) {
		this.inserirPagamentoOutputPort = inserirPagamentoOutputPort;
	}

	@Override
	public PagamentoEntity inserir(Pagamento Pagamento) {
		return this.inserirPagamentoOutputPort.inserir(Pagamento);
	}

}
