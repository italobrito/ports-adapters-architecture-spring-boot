package br.com.portsadapters.fastfoodapp.config.endereco;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.portsadapters.fastfoodapp.adapters.out.endereco.AtualizarEnderecoAdapter;
import br.com.portsadapters.fastfoodapp.adapters.out.endereco.BuscarEnderecoPorIdAdapter;
import br.com.portsadapters.fastfoodapp.application.core.usecase.endereco.AtualizarEnderecoUseCase;

@Configuration
@ComponentScan(basePackages = "br.com.fastfoodapp.app")
public class AtualizarEnderecoConfig {


    @Bean
    public AtualizarEnderecoUseCase atualizarEnderecoUseCase(
    		AtualizarEnderecoAdapter atualizarEnderecoAdapter,
    		BuscarEnderecoPorIdAdapter buscarEnderecoPorIdAdapter
    ) {
        return new AtualizarEnderecoUseCase(atualizarEnderecoAdapter, buscarEnderecoPorIdAdapter);
    }
	
}
