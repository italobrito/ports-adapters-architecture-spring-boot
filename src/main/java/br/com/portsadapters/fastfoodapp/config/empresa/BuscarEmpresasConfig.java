package br.com.portsadapters.fastfoodapp.config.empresa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.empresa.BuscarEmpresasAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.empresa.BuscarEmpresasUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class BuscarEmpresasConfig {
	
    @Bean
    public BuscarEmpresasUseCase buscarEmpresasUseCase(
    		BuscarEmpresasAdapter buscarEmpresasAdapter
    ) {
        return new BuscarEmpresasUseCase(buscarEmpresasAdapter);
    }

}
