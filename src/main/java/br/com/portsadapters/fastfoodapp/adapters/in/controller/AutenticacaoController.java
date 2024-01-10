
package br.com.portsadapters.fastfoodapp.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.usuario.UsuarioRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.usuario.AutenticacaoResponse;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.usuario.DadosToken;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.UsuarioRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.usuario.UsuarioEntity;
import br.com.portsadapters.fastfoodapp.config.seguranca.TokenService;
import jakarta.validation.Valid;

@RestController

@RequestMapping("auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/realizar-login")
	public ResponseEntity<DadosToken> efetuarLogin(@RequestBody @Valid AutenticacaoResponse dados) {
		var token = new UsernamePasswordAuthenticationToken(dados.getLogin(), dados.getPassword());
		var authentication = authenticationManager.authenticate(token);
		var tokenJWT = tokenService.gerarToken((UsuarioEntity) authentication.getPrincipal());
		return ResponseEntity.ok(new DadosToken(tokenJWT));
	}

	@PostMapping("/cadastrar-usuario")
	public ResponseEntity<UsuarioEntity> cadastrarUsuario(@RequestBody @Valid UsuarioRequest data) {
		if (this.usuarioRepository.findByLogin(data.getLogin()) != null)
			return ResponseEntity.badRequest().build();
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
		UsuarioEntity newUser = new UsuarioEntity(data.getLogin(), encryptedPassword, data.getRole().toString());
		System.out.print(newUser);
		this.usuarioRepository.save(newUser);
		return ResponseEntity.ok(newUser);
	}

}
