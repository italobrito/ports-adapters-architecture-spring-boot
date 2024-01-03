package br.com.portsadapters.fastfoodapp.config.pagamento.formas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.pagamento.formas.InserirDinheiroAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.pagamento.formas.InserirDinheiroUseCase;


@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class InserirDinheiroConfig {
	@Bean
	public InserirDinheiroUseCase inserirDinheiroUseCase(
			InserirDinheiroAdapter inserirDinheiroAdapter) {
		return new InserirDinheiroUseCase(inserirDinheiroAdapter);
	}
}
