package br.com.portsadapters.fastfoodapp.application.ports.in.cliente;

import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;

public interface InserirClienteInputPort {
	void inserir(Cliente cliente);
}
