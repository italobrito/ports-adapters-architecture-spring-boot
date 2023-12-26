package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.InsumoRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.LancheRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.InsumoResponse;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.LancheResponse;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Insumo;
import br.com.portsadapters.fastfoodapp.application.core.domain.Lanche;

@Component
public class LancheMapper {
	
	public LancheResponse paraLancheResponse(LancheEntity lancheEntity) {
		LancheResponse lancheResponse = new LancheResponse();
		lancheResponse.setId(lancheEntity.getId());
		lancheResponse.setNome(lancheEntity.getNome());
		lancheResponse.setPreco(lancheEntity.getPreco());
		
        List<InsumoResponse> insumos = new ArrayList<>();
        
        for (InsumoEntity insumoEntity : lancheEntity.getInsumos()) {
        	
        	InsumoResponse insumoCriado = new InsumoResponse();
            
        	insumoCriado.setId(insumoEntity.getId());
        	insumoCriado.setNome(insumoEntity.getNome());
			/* insumoCriado.setPreco(insumoEntity.getPreco()); */
        	insumoCriado.setQuantidade(insumoEntity.getQuantidade());
			/* insumoCriado.setImagem(insumoEntity.getImagem()); */
        	insumoCriado.setPesoEmGramas(insumoEntity.getPesoEmGramas());
      	
        	//insumoRequest.setLanches(lancheRequest.getLanches());
            
        	insumos.add(insumoCriado);
        }
        
        lancheResponse.setInsumos(insumos);
		
		return lancheResponse;
	}
	
	public Lanche paraLanche(LancheRequest lancheRequest) {
		Lanche lanche = new Lanche();
		
		lanche.setId(lancheRequest.getId());
		lanche.setNome(lancheRequest.getNome());
		lanche.setPreco(lancheRequest.getPreco());
		
        List<Insumo> insumos = new ArrayList<>();
       
        for (InsumoRequest insumoRequest : lancheRequest.getInsumos()) {
        	
        	Insumo insumoCriado = new Insumo();
            
        	insumoCriado.setId(insumoRequest.getId());
        	insumoCriado.setNome(insumoRequest.getNome());
        	insumoCriado.setPreco(insumoRequest.getPreco());
        	insumoCriado.setQuantidade(insumoRequest.getQuantidade());
        	insumoCriado.setImagem(insumoRequest.getImagem());
        	insumoCriado.setPesoEmGramas(insumoRequest.getPesoEmGramas());
      	
        	//insumoRequest.setLanches(lancheRequest.getLanches());
            
        	insumos.add(insumoCriado);
        }
		
		lanche.setInsumos(insumos);
		
		return lanche;
	}

}
