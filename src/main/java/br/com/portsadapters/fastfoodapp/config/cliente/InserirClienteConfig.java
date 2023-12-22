package br.com.portsadapters.fastfoodapp.config.cliente;

import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.cliente.InserirClienteAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.cliente.InserirClienteUseCase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class InserirClienteConfig {
	
	@Bean
	public InserirClienteUseCase inserirClienteUseCase(InserirClienteAdapter inserirClienteAdapter) {
		return new InserirClienteUseCase(inserirClienteAdapter);
	}

}
