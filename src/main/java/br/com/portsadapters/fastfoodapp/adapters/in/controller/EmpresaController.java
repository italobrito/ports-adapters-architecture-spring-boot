package br.com.portsadapters.fastfoodapp.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {
	
		@Autowired
		private InserirEmpresaInputPort inserirEmpresaInputPort; 
		
		@Autowired
		private EmpresaMapper empresaMapper;
		
	   @PostMapping
	    public ResponseEntity<EmpresaEntity> inserir(@Valid @RequestBody EmpresaRequest empresaRequest) {
		   Empresa empresa = empresaMapper.paraEmpresa(empresaRequest);
		   EmpresaEntity empresaEntity = inserirEmpresaInputPort.inserir(empresa);
           return ResponseEntity.ok(empresaEntity);
	    }

}
