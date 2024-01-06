package br.com.portsadapters.fastfoodapp.adapters.in.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.PedidoMapperInterface;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.PedidoRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoStatus;
import br.com.portsadapters.fastfoodapp.application.ports.in.pedido.AtualizarPedidoStatusInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.pedido.BuscarPedidoPorIdInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.pedido.BuscarPedidosInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.pedido.InserirPedidoInputPort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/pedido")
public class PedidoController {
	@Autowired
	private InserirPedidoInputPort inserirPedidoInputPort;

	@Autowired
	private BuscarPedidoPorIdInputPort buscarPedidoPorIdInputPort;

	@Autowired
	private BuscarPedidosInputPort buscarPedidosInputPort;

	@Autowired
	private AtualizarPedidoStatusInputPort atualizarPedidoStatusInputPort;

	/*
	 * @Autowired private PedidoMapper pedidoMapper;
	 */

	@Autowired
	private PedidoMapperInterface pedidoMapperInterface;

	@Operation(summary = "Mudar o status do pedido.", description = "Atualiza os status do pedido")
	@PatchMapping("/{id}")
	public ResponseEntity<PedidoEntity> atualizarPedidoStatus(@PathVariable Long id,
			@RequestParam TipoStatus tipoStatus) {
		atualizarPedidoStatusInputPort.atualizarStatusPedido(id, tipoStatus);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "Inserir um pedido.", description = "Cria um pedido no seu status inicial")
	@PostMapping
	public ResponseEntity<PedidoEntity> inserir(@Valid @RequestBody PedidoRequest pedidoRequest) {
		
		// Pedido pedido = pedidoMapper.paraPedido(pedidoRequest);
		
		Pedido pedido = pedidoMapperInterface.paraPedidoRequest(pedidoRequest);
		
		PedidoEntity pedidoSalvo = inserirPedidoInputPort.inserir(pedido);
		return ResponseEntity.ok(pedidoSalvo);
	}

	@Operation(summary = "Buscar pedido por Id", description = "Pesquisa um pedido através do seu id.")
	@GetMapping("/{id}")
	public ResponseEntity<PedidoEntity> buscarPorId(@PathVariable Long id) {
		Optional<PedidoEntity> pedido = buscarPedidoPorIdInputPort.buscarPorId(id);
		return ResponseEntity.ok(pedido.get());
	}

	@Operation(summary = "Buscar todos os pedidos", description = "Pesquisa todos os pedidos.")
	@GetMapping
	public ResponseEntity<List<PedidoEntity>> buscarTodos() {
		List<PedidoEntity> pedidos = buscarPedidosInputPort.buscarTodos();
		return ResponseEntity.ok().body(pedidos);
	}
}
