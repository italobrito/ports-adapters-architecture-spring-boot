package br.com.portsadapters.fastfoodapp.config.lanche;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.lanche.BuscarLanchePorIdAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.lanche.BuscarLanchePorIdUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class BuscarLanchePorIdConfig {

    @Bean
    public BuscarLanchePorIdUseCase buscarLanchePorIdUseCase(
    		BuscarLanchePorIdAdapter buscarLanchePorIdAdapter
    ) {
        return new BuscarLanchePorIdUseCase(buscarLanchePorIdAdapter);
    }
}
