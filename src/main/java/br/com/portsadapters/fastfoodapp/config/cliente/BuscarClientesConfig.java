package br.com.portsadapters.fastfoodapp.config.cliente;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.cliente.BuscarClientesAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.cliente.BuscarClientesUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class BuscarClientesConfig {
	
    @Bean
    public BuscarClientesUseCase buscarClientesUseCase(
    		BuscarClientesAdapter buscarClientesAdapter
    ) {
        return new BuscarClientesUseCase(buscarClientesAdapter);
    }

}
