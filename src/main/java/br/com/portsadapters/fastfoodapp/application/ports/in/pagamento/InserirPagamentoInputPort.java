package br.com.portsadapters.fastfoodapp.application.ports.in.pagamento;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.PagamentoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.Pagamento;

public interface InserirPagamentoInputPort {
	PagamentoEntity inserir(Pagamento pagamento);
}
