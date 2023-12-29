package br.com.portsadapters.fastfoodapp.config.pedido;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.pedido.BuscarPedidoPorIdAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.pedido.BuscarPedidoPorIdUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class BuscarPedidoPorIdConfig {

    @Bean
    public BuscarPedidoPorIdUseCase buscarPedidoPorIdUseCase(
    		BuscarPedidoPorIdAdapter buscarPedidoPorIdAdapter
    ) {
        return new BuscarPedidoPorIdUseCase(buscarPedidoPorIdAdapter);
    }
}
