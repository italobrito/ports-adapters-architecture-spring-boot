package br.com.portsadapters.fastfoodapp.application.ports.out.pagamento;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.FormaPagamento;

public interface InserirFormaPagamentoOutputPort {
	FormaPagamentoEntity inserir(FormaPagamento formaPagamento);
}
