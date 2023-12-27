package br.com.portsadapters.fastfoodapp.config.insumo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.insumo.BuscarInsumoPorIdAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.insumo.BuscarInsumoPorIdUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class BuscarInsumoPorIdConfig {
    @Bean
    public BuscarInsumoPorIdUseCase buscarInsumoPorIdUseCase(
    		BuscarInsumoPorIdAdapter buscarInsumoPorIdAdapter
    ) {
        return new BuscarInsumoPorIdUseCase(buscarInsumoPorIdAdapter);
    }
}
