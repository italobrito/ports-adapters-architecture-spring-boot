package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.InsumoRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.LancheRequest;
import br.com.portsadapters.fastfoodapp.application.core.domain.Insumo;
import br.com.portsadapters.fastfoodapp.application.core.domain.Lanche;

@Component
public class LancheMapper {
	
	public Lanche paraLanche(LancheRequest lancheRequest) {
		Lanche lanche = new Lanche();
		
		lanche.setId(lancheRequest.getId());
		lanche.setNome(lancheRequest.getNome());
		lanche.setPreco(lancheRequest.getPreco());
		
        List<Insumo> insumos = new ArrayList<>();
       
        for (InsumoRequest insumoRequest : lancheRequest.getInsumos()) {
        	
        	Insumo insumoCriado = new Insumo();
            
        	insumoRequest.setId(lancheRequest.getId());
        	insumoRequest.setNome(lancheRequest.getNome());
        	insumoRequest.setPreco(lancheRequest.getPreco());
       	
        	//insumoRequest.setLanches(lancheRequest.getLanches());
            
        	insumos.add(insumoCriado);
        }
		
		lanche.setInsumos(insumos);
		
		return lanche;
	}

}
