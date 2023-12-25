package br.com.portsadapters.fastfoodapp.application.ports.out.cliente;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;

public interface AtualizarClienteOutputPort {
	ClienteEntity atualizar(Cliente cliente);
}
