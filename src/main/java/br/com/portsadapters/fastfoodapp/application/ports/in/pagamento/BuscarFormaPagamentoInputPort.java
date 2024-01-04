package br.com.portsadapters.fastfoodapp.application.ports.in.pagamento;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;

public interface BuscarFormaPagamentoInputPort {
	List<FormaPagamentoEntity> buscarTodos();
}
