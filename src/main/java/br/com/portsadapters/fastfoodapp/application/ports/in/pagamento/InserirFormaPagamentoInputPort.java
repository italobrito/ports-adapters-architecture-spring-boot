package br.com.portsadapters.fastfoodapp.application.ports.in.pagamento;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.FormaPagamento;

public interface InserirFormaPagamentoInputPort {
	FormaPagamentoEntity inserir(FormaPagamento formaPagamento);
}
