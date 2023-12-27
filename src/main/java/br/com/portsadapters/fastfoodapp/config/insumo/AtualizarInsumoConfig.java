package br.com.portsadapters.fastfoodapp.config.insumo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.insumo.AtualizarInsumoAdapter;
import br.com.portsadapters.fastfoodapp.adapters.out.insumo.BuscarInsumoPorIdAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.insumo.AtualizarInsumoUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class AtualizarInsumoConfig {
    @Bean
    public AtualizarInsumoUseCase atualizarInsumoUseCase(
    		AtualizarInsumoAdapter atualizarInsumoAdapter,
    		BuscarInsumoPorIdAdapter buscarInsumoPorIdAdapter
    ) {
        return new AtualizarInsumoUseCase(atualizarInsumoAdapter, buscarInsumoPorIdAdapter);
    }
}
