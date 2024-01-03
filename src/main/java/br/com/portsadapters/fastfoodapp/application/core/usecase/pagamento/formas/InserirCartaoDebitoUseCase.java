package br.com.portsadapters.fastfoodapp.application.core.usecase.pagamento.formas;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoDebitoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoDebito;
import br.com.portsadapters.fastfoodapp.application.ports.in.pagamento.formas.InserirCartaoDebitoInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.pagamento.formas.InserirCartaoDebitoOutputPort;

public class InserirCartaoDebitoUseCase implements InserirCartaoDebitoInputPort {
	private final InserirCartaoDebitoOutputPort inserirCartaoDebitoOutputPort;
	
	public InserirCartaoDebitoUseCase(InserirCartaoDebitoOutputPort inserirCartaoDebitoOutputPort) {
		this.inserirCartaoDebitoOutputPort = inserirCartaoDebitoOutputPort;
	}

	@Override
	public CartaoDebitoEntity inserir(CartaoDebito cartaoDebito) {
		return inserirCartaoDebitoOutputPort.inserir(cartaoDebito);
	}
}
