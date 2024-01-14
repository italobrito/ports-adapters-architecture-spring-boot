package br.com.portsadapters.fastfoodapp.config.usuario;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.usuario.InserirUsuarioAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.usuario.InserirUsuarioUseCase;


@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class InserirUsuarioConfig {
	@Bean
	public InserirUsuarioUseCase inserirUsuarioUseCase(
			InserirUsuarioAdapter inserirUsuarioAdapter) {
		return new InserirUsuarioUseCase(inserirUsuarioAdapter);
	}
}
