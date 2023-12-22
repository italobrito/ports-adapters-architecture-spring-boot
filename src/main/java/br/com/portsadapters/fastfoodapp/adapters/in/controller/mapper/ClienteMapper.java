package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.ClienteRequest;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;

@Component
public class ClienteMapper {
    public Cliente paraCliente(ClienteRequest clienteRequest) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteRequest.getNome());
        cliente.setCpf(clienteRequest.getCpf());
        cliente.setEnderecos(clienteRequest.getEnderecos());
        return cliente;
    }
}
