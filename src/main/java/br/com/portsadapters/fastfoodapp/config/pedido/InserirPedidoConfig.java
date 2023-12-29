package br.com.portsadapters.fastfoodapp.config.pedido;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.insumo.AtualizarInsumoAdapter;
import br.com.portsadapters.fastfoodapp.adapters.out.insumo.BuscarInsumoPorIdAdapter;
import br.com.portsadapters.fastfoodapp.adapters.out.pedido.InserirPedidoAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.pedido.InserirPedidoUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class InserirPedidoConfig {
	@Bean
	public InserirPedidoUseCase inserirPedidoUseCase(InserirPedidoAdapter inserirPedidoAdapter,
			BuscarInsumoPorIdAdapter buscarInsumoPorIdAdapter, AtualizarInsumoAdapter atualizarInsumoAdapter) {
		return new InserirPedidoUseCase(inserirPedidoAdapter, buscarInsumoPorIdAdapter, atualizarInsumoAdapter);
	}
}
