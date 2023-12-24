package br.com.portsadapters.fastfoodapp.config.empresa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.empresa.BuscarEmpresaPorIdAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.empresa.BuscarEmpresaPorIdUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class BuscarEmpresaPorIdConfig {

    @Bean
    public BuscarEmpresaPorIdUseCase buscarEmpresaPorIdUseCase(
    		BuscarEmpresaPorIdAdapter buscarEmpresaPorIdAdapter
    ) {
        return new BuscarEmpresaPorIdUseCase(buscarEmpresaPorIdAdapter);
    }

	
}
