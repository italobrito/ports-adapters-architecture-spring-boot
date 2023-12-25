package br.com.portsadapters.fastfoodapp.config.lanche;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.lanche.InserirLancheAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.lanche.InserirLancheUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class InserirLancheConfig {
	
	@Bean
	public InserirLancheUseCase inserirLancheUseCase(InserirLancheAdapter inserirLancheAdapter) {
		return new InserirLancheUseCase(inserirLancheAdapter);
	}

}
