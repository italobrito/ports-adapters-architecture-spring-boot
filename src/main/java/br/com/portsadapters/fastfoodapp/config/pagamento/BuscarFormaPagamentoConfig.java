package br.com.portsadapters.fastfoodapp.config.pagamento;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.pagamento.BuscarFormaPagamentoAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.pagamento.BuscarFormaPagamentoUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class BuscarFormaPagamentoConfig {
	@Bean
	public BuscarFormaPagamentoUseCase buscarFormaPagamentoUseCase(
			BuscarFormaPagamentoAdapter buscarFormaPagamentoAdapter) {
		return new BuscarFormaPagamentoUseCase(buscarFormaPagamentoAdapter);
	}
}