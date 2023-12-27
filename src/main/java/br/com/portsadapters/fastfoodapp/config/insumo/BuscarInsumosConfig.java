package br.com.portsadapters.fastfoodapp.config.insumo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.insumo.BuscarInsumosAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.insumo.BuscarInsumosUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class BuscarInsumosConfig {
    @Bean
    public BuscarInsumosUseCase buscarInsumosUseCase(
    		BuscarInsumosAdapter buscarInsumosAdapter
    ) {
        return new BuscarInsumosUseCase(buscarInsumosAdapter);
    }

}
