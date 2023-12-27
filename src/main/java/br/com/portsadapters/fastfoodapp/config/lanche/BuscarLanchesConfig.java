package br.com.portsadapters.fastfoodapp.config.lanche;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.lanche.BuscarLanchesAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.lanche.BuscarLanchesUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class BuscarLanchesConfig {

    @Bean
    public BuscarLanchesUseCase buscarLanchesUseCase(
    		BuscarLanchesAdapter buscarLanchesAdapter
    ) {
        return new BuscarLanchesUseCase(buscarLanchesAdapter);
    }
	
	
}
