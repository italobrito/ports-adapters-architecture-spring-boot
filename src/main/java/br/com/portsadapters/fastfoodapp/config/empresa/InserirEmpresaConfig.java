package br.com.portsadapters.fastfoodapp.config.empresa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.empresa.InserirEmpresaAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.empresa.InserirEmpresaUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class InserirEmpresaConfig {
	
	@Bean
	public InserirEmpresaUseCase inserirEmpresaUseCase(InserirEmpresaAdapter inserirEmpresaAdapter) {
		return new InserirEmpresaUseCase(inserirEmpresaAdapter);
	}

}
