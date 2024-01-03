package br.com.portsadapters.fastfoodapp.application.core.usecase.pagamento.formas;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.DinheiroEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.Dinheiro;
import br.com.portsadapters.fastfoodapp.application.ports.in.pagamento.formas.InserirDinheiroInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.pagamento.formas.InserirDinheiroOutputPort;

public class InserirDinheiroUseCase implements InserirDinheiroInputPort {
	private final InserirDinheiroOutputPort inserirDinheiroOutputPort;
	
	public InserirDinheiroUseCase(InserirDinheiroOutputPort inserirDinheiroOutputPort) {
		this.inserirDinheiroOutputPort = inserirDinheiroOutputPort;
	}

	@Override
	public DinheiroEntity inserir(Dinheiro Dinheiro) {
		return inserirDinheiroOutputPort.inserir(Dinheiro);
	}
}
