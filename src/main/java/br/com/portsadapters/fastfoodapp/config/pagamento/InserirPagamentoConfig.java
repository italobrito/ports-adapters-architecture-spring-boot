package br.com.portsadapters.fastfoodapp.config.pagamento;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.pagamento.InserirPagamentoAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.pagamento.InserirPagamentoUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class InserirPagamentoConfig {
	@Bean
	public InserirPagamentoUseCase inserirPagamentoUseCase(
			InserirPagamentoAdapter inserirPagamentoAdapter) {
		return new InserirPagamentoUseCase(inserirPagamentoAdapter);
	}
}
