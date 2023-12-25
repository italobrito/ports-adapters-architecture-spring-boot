package br.com.portsadapters.fastfoodapp.config.insumo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.insumo.InserirInsumoAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.insumo.InserirInsumoUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class InserirInsumoConfig {
	
	@Bean
	public InserirInsumoUseCase inserirInsumoUseCase(InserirInsumoAdapter inserirInsumoAdapter) {
		return new InserirInsumoUseCase(inserirInsumoAdapter);
	}

}
