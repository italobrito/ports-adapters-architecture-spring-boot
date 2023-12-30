package br.com.portsadapters.fastfoodapp.config.pedido;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.pedido.BuscarPedidosAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.pedido.BuscarPedidosUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class BuscarPedidosConfig {
    @Bean
    public BuscarPedidosUseCase buscarPedidosUseCase(
    		BuscarPedidosAdapter buscarPedidosAdapter
    ) {
        return new BuscarPedidosUseCase(buscarPedidosAdapter);
    }
}
