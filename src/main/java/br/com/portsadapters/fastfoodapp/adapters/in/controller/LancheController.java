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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.LancheMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.LancheRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.LancheResponse;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Lanche;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoLanche;
import br.com.portsadapters.fastfoodapp.application.ports.in.lanche.AtualizarLancheInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.lanche.BuscarLanchePorIdInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.lanche.BuscarLanchesInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.lanche.BuscarLanchesPorTipoInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.lanche.InserirLancheInputPort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/lanche")
public class LancheController {
	
	@Autowired
	private InserirLancheInputPort inserirLancheInputPort;

	@Autowired
	private BuscarLanchePorIdInputPort buscarLanchePorIdInputPort;
	
	@Autowired
	private BuscarLanchesPorTipoInputPort buscarLanchesPorTipoInputPort;
	
	@Autowired
	private BuscarLanchesInputPort buscarLanchesInputPort;
	
	@Autowired
	private AtualizarLancheInputPort atualizarLancheInputPort;
	
	@Autowired
	private LancheMapper lancheMapper;
	
	@Operation(summary = "Inserir lanche.", description = "Insere um lanche.")
	@PostMapping
	public ResponseEntity<LancheEntity> inserir(@Valid @RequestBody LancheRequest lancheRequest) {
		Lanche lanche = lancheMapper.paraLanche(lancheRequest);
		LancheEntity lancheSalvo = inserirLancheInputPort.inserir(lanche);
		return ResponseEntity.ok(lancheSalvo);	
	}
	
	@Operation(summary = "Edita um lanche.", description = "Edita um lanche e retorna o objeto editado.")
    @PutMapping("/{id}")
    public ResponseEntity<LancheEntity> update(@PathVariable final Long id, @Valid @RequestBody LancheRequest lancheRequest) {
        Lanche lanche = lancheMapper.paraLanche(lancheRequest);
        LancheEntity insumoAlterado = atualizarLancheInputPort.atualizar(lanche);
        return ResponseEntity.ok(insumoAlterado);
    }
	
	@Operation(summary = "Buscar lanche por Id.", description = "Pesquisa por um lanche específico.")
	@GetMapping("/{id}")
	public ResponseEntity<LancheResponse> buscarPorId(@PathVariable Long id) {
		Optional<LancheEntity> lancheEntity = buscarLanchePorIdInputPort.buscarPorId(id);
		LancheResponse lancheResponse = lancheMapper.paraLancheResponse(lancheEntity.get());
		return ResponseEntity.ok(lancheResponse);
	}
	

	@Operation(summary = "Buscar todos os lanches", description = "Pesquisa lanches")
	@GetMapping
	public ResponseEntity<List<LancheEntity>> buscarTodos() {
		List<LancheEntity> lanches = buscarLanchesInputPort.buscarTodos();
		return ResponseEntity.ok().body(lanches);
	}
	
	
	@Operation(summary = "Buscar lanches por categoria", description = "Pesquisa lanches aplicando filtro de tipo")
	@GetMapping("/status")
	public ResponseEntity<List<LancheEntity>> buscarPedidosPorStatus(@RequestParam TipoLanche lipoLanche) {
		List<LancheEntity> lanches = buscarLanchesPorTipoInputPort.buscarLanchesPorTipo(lipoLanche);
		return ResponseEntity.ok().body(lanches);
	}

}
