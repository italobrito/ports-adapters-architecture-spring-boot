package br.com.portsadapters.fastfoodapp.config.lanche;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.lanche.BuscarLanchesPorTipoAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.lanche.BuscarLanchesPorTipoUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class BuscarLanchesPorTipoConfig {
    @Bean
    public BuscarLanchesPorTipoUseCase BuscarLanchePorTipoUseCase(
    		BuscarLanchesPorTipoAdapter buscarLanchePorTipoAdapter
    ) {
        return new BuscarLanchesPorTipoUseCase(buscarLanchePorTipoAdapter);
    }
}
