package br.com.portsadapters.fastfoodapp.config.cliente;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.cliente.AtualizarClienteAdapter;
import br.com.portsadapters.fastfoodapp.adapters.out.cliente.BuscarClientePorIdAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.cliente.AtualizarClienteUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class AtualizarClienteConfig {

    @Bean
    public AtualizarClienteUseCase atualizarClienteUseCase(
    		AtualizarClienteAdapter atualizarClienteAdapter,
    		BuscarClientePorIdAdapter buscarClientePorIdAdapter
    ) {
        return new AtualizarClienteUseCase(atualizarClienteAdapter, buscarClientePorIdAdapter);
    }
    
}
