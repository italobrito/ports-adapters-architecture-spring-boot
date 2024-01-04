package br.com.portsadapters.fastfoodapp.application.ports.out.pagamento;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;

public interface BuscarFormaPagamentoOutputPort {
	List<FormaPagamentoEntity> buscarTodos();
}
