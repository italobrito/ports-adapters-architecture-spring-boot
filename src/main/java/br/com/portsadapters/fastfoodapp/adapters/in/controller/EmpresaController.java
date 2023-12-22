package br.com.portsadapters.fastfoodapp.adapters.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.EmpresaRequest;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {
	
	   @PostMapping
	    public ResponseEntity<Void> insert(@Valid @RequestBody EmpresaRequest empresaRequest) {
		   System.out.print(empresaRequest);
		   return ResponseEntity.ok().build();
	    }

}
