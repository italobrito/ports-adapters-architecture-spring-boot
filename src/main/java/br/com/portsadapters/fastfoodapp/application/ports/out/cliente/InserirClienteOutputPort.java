package br.com.portsadapters.fastfoodapp.application.ports.out.cliente;

import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;

public interface InserirClienteOutputPort {
	void inserir(Cliente cliente);
}
