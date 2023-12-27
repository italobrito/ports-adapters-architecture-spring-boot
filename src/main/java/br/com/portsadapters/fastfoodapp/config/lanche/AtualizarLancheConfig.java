package br.com.portsadapters.fastfoodapp.config.lanche;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.lanche.AtualizarLancheAdapter;
import br.com.portsadapters.fastfoodapp.adapters.out.lanche.BuscarLanchePorIdAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.lanche.AtualizarLancheUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class AtualizarLancheConfig {
    @Bean
    public AtualizarLancheUseCase atualizarLancheUseCase(
    		AtualizarLancheAdapter atualizarLancheAdapter,
    		BuscarLanchePorIdAdapter buscarLanchePorIdAdapter
    ) {
        return new AtualizarLancheUseCase(atualizarLancheAdapter, buscarLanchePorIdAdapter);
    }
}
