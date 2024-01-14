package br.com.portsadapters.fastfoodapp.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.UsuarioMapperInterface;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.usuario.UsuarioRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.usuario.UsuarioEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Usuario;
import br.com.portsadapters.fastfoodapp.application.ports.in.usuario.InserirUsuarioInputPort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
	
	@Autowired
	private InserirUsuarioInputPort inserirUsuarioInputPort;
	
	@Autowired
	private UsuarioMapperInterface usuarioMapperInterface;
	
	@Operation(summary = "Cadastra um usuário.", description = "Cadastra usuário com role (ADMIN, USER, COZINHA)")
	@PostMapping
	public ResponseEntity<UsuarioEntity> inserir(@RequestBody @Valid UsuarioRequest usuarioRequest) {
		Usuario usuario = usuarioMapperInterface.paraUsuario(usuarioRequest);
		return inserirUsuarioInputPort.inserir(usuario);
	}

}
