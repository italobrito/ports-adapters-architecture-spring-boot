package br.com.portsadapters.fastfoodapp.config.pedido;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.pedido.BuscarPedidosPorStatusAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.pedido.BuscarPedidosPorStatusUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class BuscarPedidosPorStatusConfig {
    @Bean
    public BuscarPedidosPorStatusUseCase buscarPedidosPorStatusUseCase(
    		BuscarPedidosPorStatusAdapter buscarPedidosPorStatusAdapter
    ) {
        return new BuscarPedidosPorStatusUseCase(buscarPedidosPorStatusAdapter);
    }
}

