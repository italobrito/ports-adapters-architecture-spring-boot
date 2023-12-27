package br.com.portsadapters.fastfoodapp.config.empresa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.empresa.AtualizarEmpresaAdapter;
import br.com.portsadapters.fastfoodapp.adapters.out.empresa.BuscarEmpresaPorIdAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.empresa.AtualizarEmpresaUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class AtualizarEmpresaConfig {
    @Bean
    public AtualizarEmpresaUseCase atualizarEmpresaUseCase(
    		AtualizarEmpresaAdapter atualizarEmpresaAdapter,
    		BuscarEmpresaPorIdAdapter buscarEmpresaPorIdAdapter
    ) {
        return new AtualizarEmpresaUseCase(atualizarEmpresaAdapter, buscarEmpresaPorIdAdapter);
    }
    
}
