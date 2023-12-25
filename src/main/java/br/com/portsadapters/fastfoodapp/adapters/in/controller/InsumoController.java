package br.com.portsadapters.fastfoodapp.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.InsumoMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.InsumoRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Insumo;
import br.com.portsadapters.fastfoodapp.application.ports.in.insumo.InserirInsumoInputPort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/insumo")
public class InsumoController {
	
	@Autowired
	private InserirInsumoInputPort inserirInsumoInputPort;
	
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

}
