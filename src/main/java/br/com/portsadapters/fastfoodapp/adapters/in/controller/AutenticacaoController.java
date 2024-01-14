
package br.com.portsadapters.fastfoodapp.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.usuario.AutenticacaoResponse;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.usuario.DadosToken;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.usuario.UsuarioEntity;
import br.com.portsadapters.fastfoodapp.config.seguranca.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@Operation(summary = "Faça seu login.", description = "Faz login de usuário.")
	@PostMapping("/realizar-login")
	public ResponseEntity<DadosToken> efetuarLogin(@RequestBody @Valid AutenticacaoResponse dados) {
		var token = new UsernamePasswordAuthenticationToken(dados.getLogin(), dados.getPassword());
		var authentication = authenticationManager.authenticate(token);
		var tokenJWT = tokenService.gerarToken((UsuarioEntity) authentication.getPrincipal());
		return ResponseEntity.ok(new DadosToken(tokenJWT));
	}

}
