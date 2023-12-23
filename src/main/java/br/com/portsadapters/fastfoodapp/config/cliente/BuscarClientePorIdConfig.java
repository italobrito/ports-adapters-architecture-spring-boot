package br.com.portsadapters.fastfoodapp.config.cliente;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.cliente.BuscarClientePorIdAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.cliente.BuscarClientePorIdUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class BuscarClientePorIdConfig {

    @Bean
    public BuscarClientePorIdUseCase buscarClientePorIdUseCase(
    		BuscarClientePorIdAdapter buscarClientePorIdAdapter
    ) {
        return new BuscarClientePorIdUseCase(buscarClientePorIdAdapter);
    }

}