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

import jakarta.validation.Valid;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.EmpresaMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.EmpresaRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.EmpresaResponse;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;
import br.com.portsadapters.fastfoodapp.application.ports.in.empresa.InserirEmpresaInputPort;
import io.swagger.v3.oas.annotations.Operation;
import br.com.portsadapters.fastfoodapp.application.ports.in.empresa.AtualizarEmpresaInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.empresa.BuscarEmpresaPorIdInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.empresa.BuscarEmpresasInputPort;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {

	@Autowired
	private InserirEmpresaInputPort inserirEmpresaInputPort;
	
	@Autowired
	private AtualizarEmpresaInputPort atualizarEmpresaInputPort;

	@Autowired
	private BuscarEmpresasInputPort buscarEmpresasInputPort;

	@Autowired
	private BuscarEmpresaPorIdInputPort buscarEmpresaPorIdInputPort;

	@Autowired
	private EmpresaMapper empresaMapper;
	

	@Operation(summary = "Insere uma empresa.", description = "Insere uma empresa e suas associações.")
	@PostMapping
	public ResponseEntity<EmpresaEntity> inserir(@Valid @RequestBody EmpresaRequest empresaRequest) {
		Empresa empresa = empresaMapper.paraEmpresa(empresaRequest);
		EmpresaEntity empresaEntity = inserirEmpresaInputPort.inserir(empresa);
		return ResponseEntity.ok(empresaEntity);
	}
	
	@Operation(summary = "Edita uma empresa.", description = "Edita uma empresa e retorna o objeto editado.")
    @PutMapping("/{id}")
    public ResponseEntity<EmpresaEntity> update(@PathVariable final Long id, @Valid @RequestBody EmpresaRequest empresaRequest) {
		Empresa empresa = empresaMapper.paraEmpresa(empresaRequest);
		EmpresaEntity empresaAlterado = atualizarEmpresaInputPort.atualizar(empresa);
        return ResponseEntity.ok(empresaAlterado);
    }


	@Operation(summary = "Buscar todas as empresas cadastradas.", description = "Pesquisa todas as empresas.")
	@GetMapping
	public ResponseEntity<List<EmpresaResponse>> buscarTodos() {
		List<EmpresaEntity> empresas = buscarEmpresasInputPort.buscarTodos();
		List<EmpresaResponse> empresaResponse = empresaMapper.paraEmpresaResponse(empresas);
		return ResponseEntity.ok().body(empresaResponse);
	}

	@Operation(summary = "Buscar empresa por Id", description = "Pesquisa uma empresa através do id.")
	@GetMapping("/{id}")
	public ResponseEntity<EmpresaEntity> buscarPorId(@PathVariable Long id) {
		Optional<EmpresaEntity> empresa = buscarEmpresaPorIdInputPort.buscarPorId(id);
		return ResponseEntity.ok(empresa.get());
	}

}
