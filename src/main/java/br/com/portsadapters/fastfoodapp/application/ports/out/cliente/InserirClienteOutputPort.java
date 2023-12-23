package br.com.portsadapters.fastfoodapp.application.ports.out.cliente;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;

public interface InserirClienteOutputPort {
	ClienteEntity inserir(Cliente cliente);
	List<ClienteEntity> inserirTodos(List<Cliente> clientes);
}
