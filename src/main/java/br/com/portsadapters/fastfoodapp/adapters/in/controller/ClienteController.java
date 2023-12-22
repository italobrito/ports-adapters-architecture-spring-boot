package br.com.portsadapters.fastfoodapp.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.ClienteMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.ClienteRequest;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.ports.in.cliente.InserirClienteInputPort;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
	
	@Autowired
	private InserirClienteInputPort inserirClienteInputPort; 
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	@PostMapping
	public ResponseEntity<Void> inserir(@Valid @RequestBody ClienteRequest clienteRequest) {
		Cliente cliente = clienteMapper.paraCliente(clienteRequest);
		inserirClienteInputPort.inserir(cliente);
		return ResponseEntity.ok().build();
	}

}
