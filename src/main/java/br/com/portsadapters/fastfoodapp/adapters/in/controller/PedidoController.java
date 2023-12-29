package br.com.portsadapters.fastfoodapp.adapters.in.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.PedidoMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.PedidoRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;
import br.com.portsadapters.fastfoodapp.application.ports.in.pedido.BuscarPedidoPorIdInputPort;
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
	private PedidoMapper pedidoMapper;

	@Operation(summary = "Inserir um pedido.", description = "Cria um pedido no seu status inicial")
	@PostMapping
	public ResponseEntity<PedidoEntity> inserir(@Valid @RequestBody PedidoRequest pedidoRequest) {
		Pedido pedido = pedidoMapper.paraPedido(pedidoRequest);
		PedidoEntity pedidoSalvo = inserirPedidoInputPort.inserir(pedido);
		return ResponseEntity.ok(pedidoSalvo);
	}
	
	@Operation(summary = "Buscar pedido por Id", description = "Pesquisa um pedido através do seu id.")
	@GetMapping("/{id}")
	public ResponseEntity<PedidoEntity> buscarPorId(@PathVariable Long id) {
		Optional<PedidoEntity> pedido = buscarPedidoPorIdInputPort.buscarPorId(id);
		return ResponseEntity.ok(pedido.get());
	}
}
