package br.com.portsadapters.fastfoodapp.adapters.in.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.ClienteMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.ClienteRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.ports.in.cliente.AtualizarClienteInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.cliente.BuscarClientePorIdInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.cliente.BuscarClientesInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.cliente.InserirClienteInputPort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

	@Autowired
	private InserirClienteInputPort inserirClienteInputPort;

	@Autowired
	private BuscarClientePorIdInputPort buscarClientePorIdInputPort;

	@Autowired
	private BuscarClientesInputPort buscarClientesInputPort;
	
	@Autowired
	private AtualizarClienteInputPort atualizarClienteInputPort; 

	@Autowired
	private ClienteMapper clienteMapper;

	@Operation(summary = "Inserir cliente.", description = "Insere um cliente e retornar o objeto criado.")
	@PostMapping
	public ResponseEntity<ClienteEntity> inserir(@Valid @RequestBody ClienteRequest clienteRequest) {
		Cliente cliente = clienteMapper.paraCliente(clienteRequest);
		ClienteEntity clienteSalvo = inserirClienteInputPort.inserir(cliente);
		return ResponseEntity.ok(clienteSalvo);
	}

	@Operation(summary = "Buscar cliente por Id", description = "Pesquisa um cliente através do seu id.")
	@GetMapping("/{id}")
	public ResponseEntity<ClienteEntity> buscarPorId(@PathVariable Long id) {
		Optional<ClienteEntity> cliente = buscarClientePorIdInputPort.buscarPorId(id);
		return ResponseEntity.ok(cliente.get());
	}

	@Operation(summary = "Buscar todos os clientes", description = "Pesquisa todos os clientes.")
	@GetMapping
	public ResponseEntity<List<ClienteEntity>> buscarTodos() {
		List<ClienteEntity> clientes = buscarClientesInputPort.buscarTodos();
		return ResponseEntity.ok().body(clientes);
	}
	
	@Operation(summary = "Editar um cliente.", description = "Edita um cliente e retorna o objeto editado.")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> update(@PathVariable final Long id, @Valid @RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = clienteMapper.paraCliente(clienteRequest);
        ClienteEntity clienteAlterado = atualizarClienteInputPort.atualizar(cliente);
        return ResponseEntity.ok(clienteAlterado);
    }

}
