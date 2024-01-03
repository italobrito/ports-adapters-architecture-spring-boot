package br.com.portsadapters.fastfoodapp.config.pagamento.formas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.pagamento.formas.InserirCartaoCreditoAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.pagamento.formas.InserirCartaoCreditoUseCase;


@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class InserirCartaoCreditoConfig {
	@Bean
	public InserirCartaoCreditoUseCase inserirCartaoCreditoUseCase(
			InserirCartaoCreditoAdapter inserirCartaoCreditoAdapter) {
		return new InserirCartaoCreditoUseCase(inserirCartaoCreditoAdapter);
	}
}
