package br.com.portsadapters.fastfoodapp.adapters.in.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.EmpresaMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.EmpresaRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;
import br.com.portsadapters.fastfoodapp.application.ports.in.empresa.InserirEmpresaInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.empresa.BuscarEmpresaPorIdInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.in.empresa.BuscarEmpresasInputPort;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {

	@Autowired
	private InserirEmpresaInputPort inserirEmpresaInputPort;

	@Autowired
	private BuscarEmpresasInputPort buscarEmpresasInputPort;

	@Autowired
	private BuscarEmpresaPorIdInputPort buscarEmpresaPorIdInputPort;

	@Autowired
	private EmpresaMapper empresaMapper;

	@PostMapping
	public ResponseEntity<EmpresaEntity> inserir(@Valid @RequestBody EmpresaRequest empresaRequest) {
		Empresa empresa = empresaMapper.paraEmpresa(empresaRequest);
		EmpresaEntity empresaEntity = inserirEmpresaInputPort.inserir(empresa);
		return ResponseEntity.ok(empresaEntity);
	}

	@GetMapping
	public ResponseEntity<List<EmpresaEntity>> buscarTodos() {
		List<EmpresaEntity> clientes = buscarEmpresasInputPort.buscarTodos();
		return ResponseEntity.ok().body(clientes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmpresaEntity> buscarPorId(@PathVariable Long id) {
		Optional<EmpresaEntity> empresa = buscarEmpresaPorIdInputPort.buscarPorId(id);
		return ResponseEntity.ok(empresa.get());
	}

}
