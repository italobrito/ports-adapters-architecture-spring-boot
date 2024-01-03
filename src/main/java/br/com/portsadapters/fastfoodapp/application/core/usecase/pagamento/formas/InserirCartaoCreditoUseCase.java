package br.com.portsadapters.fastfoodapp.application.core.usecase.pagamento.formas;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoCreditoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoCredito;
import br.com.portsadapters.fastfoodapp.application.ports.in.pagamento.formas.InserirCartaoCreditoInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.pagamento.formas.InserirCartaoCreditoOutputPort;

public class InserirCartaoCreditoUseCase implements InserirCartaoCreditoInputPort {
	private final InserirCartaoCreditoOutputPort inserirCartaoCreditoOutputPort;
	
	public InserirCartaoCreditoUseCase(InserirCartaoCreditoOutputPort inserirCartaoCreditoOutputPort) {
		this.inserirCartaoCreditoOutputPort = inserirCartaoCreditoOutputPort;
	}

	@Override
	public CartaoCreditoEntity inserir(CartaoCredito cartaoCredito) {
		return inserirCartaoCreditoOutputPort.inserir(cartaoCredito);
	}
}
