package br.com.portsadapters.fastfoodapp.config.seguranca;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		var tokenJWT = recuperarToken(request);

		if (tokenJWT != null) {
			var login = tokenService.validarToken(tokenJWT);
			UserDetails user = usuarioRepository.findByLogin(login);

			var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			System.out.println("Possui TOKEN. EXECUTOU DENTRO DO IF");
		}

		System.out.print("RODOU O doFilterInternal");

		System.out.println(request);
		System.out.println(response);
		System.out.println(filterChain);

		var usuarioLogado = tokenService.validarToken(tokenJWT);

		System.out.println(usuarioLogado);

		System.out.println(tokenJWT);

		filterChain.doFilter(request, response);

	}

	private String recuperarToken(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization");
		if (authHeader == null) {
			// throw new RuntimeException("Token JWT não enviado no cabeçalho Authorization
			// !");
			return null;
		}
		return authHeader.replace("Bearer ", "");
	}
}
