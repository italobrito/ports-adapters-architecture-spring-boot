package br.com.portsadapters.fastfoodapp.config.pagamento;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.pagamento.InserirFormaPagamentoAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.pagamento.InserirFormaPagamentoUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class InserirFormaPagamentoConfig {
	@Bean
	public InserirFormaPagamentoUseCase inserirFormaPagamentoUseCase(
			InserirFormaPagamentoAdapter inserirFormaPagamentoAdapter) {
		return new InserirFormaPagamentoUseCase(inserirFormaPagamentoAdapter);
	}
}

