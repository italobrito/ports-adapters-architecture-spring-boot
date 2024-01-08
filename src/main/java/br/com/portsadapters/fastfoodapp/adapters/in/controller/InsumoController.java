package br.com.portsadapters.fastfoodapp.adapters.in.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.InsumoMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.InsumoRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Insumo;
import br.com.portsadapters.fastfoodapp.application.ports.in.insumo.AtualizarInsumoInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.insumo.BuscarInsumoPorIdInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.insumo.BuscarInsumosInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.insumo.InserirInsumoInputPort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/insumo")
public class InsumoController {
	
	@Autowired
	private InserirInsumoInputPort inserirInsumoInputPort;
	
	@Autowired
	private BuscarInsumosInputPort buscarInsumosInputPort;
	
	@Autowired
	private BuscarInsumoPorIdInputPort buscarInsumoPorIdInputPort;
	
	@Autowired
	private AtualizarInsumoInputPort atualizarInsumoInputPort;
	
	@Autowired
	private InsumoMapper insumoMapper;
	
	@Operation(summary = "Inserir um insumo para compor os lanches.", description = "Insere um insumo/ingrediente.")
	@PostMapping
	public ResponseEntity<InsumoEntity> inserir(@Valid @RequestBody InsumoRequest insumoRequest) {
		System.out.print(insumoRequest);
		Insumo insumo = insumoMapper.paraInsumo(insumoRequest);
		InsumoEntity insumoCriado = inserirInsumoInputPort.inserir(insumo);
		return ResponseEntity.ok(insumoCriado);
	}
	
	@Operation(summary = "Editar um insumo.", description = "Edita um insumo e retorna o objeto editado.")
    @PutMapping("/{id}")
    public ResponseEntity<InsumoEntity> update(@PathVariable final Long id, @Valid @RequestBody InsumoRequest insumoRequest) {
        Insumo insumo = insumoMapper.paraInsumo(insumoRequest);
        InsumoEntity insumoAlterado = atualizarInsumoInputPort.atualizar(insumo);
        return ResponseEntity.ok(insumoAlterado);
    }
	
	@Operation(summary = "Buscar insumo por Id.", description = "Pesquisa por um insumo específico.")
	@GetMapping("/{id}")
	public ResponseEntity<InsumoEntity> buscarPorId(@PathVariable Long id) {
		Optional<InsumoEntity> insumoEntity = buscarInsumoPorIdInputPort.buscarPorId(id);
		return ResponseEntity.ok(insumoEntity.get());
	}
	

	@Operation(summary = "Buscar todos os insumos.", description = "Pesquisa insumos.")
	@GetMapping
	public ResponseEntity<List<InsumoEntity>> buscarTodos() {
		List<InsumoEntity> insumos = buscarInsumosInputPort.buscarTodos();
		return ResponseEntity.ok().body(insumos);
	}

}
