package br.com.portsadapters.fastfoodapp.config.pedido;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.pedido.AtualizarPedidoStatusAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.pedido.AtualizarPedidoStatusUseCase;
import br.com.portsadapters.fastfoodapp.application.ports.out.pedido.BuscarPedidoPorIdOutputPort;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class AtualizarPedidoStatusConfig {
    @Bean
    public  AtualizarPedidoStatusUseCase atualizarPedidoStatusUseCase(
    		AtualizarPedidoStatusAdapter atualizarPedidoStatusAdapter,
    		BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort
    ) {
        return new AtualizarPedidoStatusUseCase(atualizarPedidoStatusAdapter, buscarPedidoPorIdOutputPort);
    }
}
