package br.com.portsadapters.fastfoodapp.application.ports.in.cliente;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;

public interface AtualizarClienteInputPort {
	ClienteEntity atualizar(Cliente cliente);
}
