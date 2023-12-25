package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Insumo;

@Component
public class InsumoEntityMapper {
	
	public InsumoEntity paraInsumoEntity(Insumo insumo) {
		
		InsumoEntity insumoEntity = new InsumoEntity();
		
		insumoEntity.setId(insumo.getId());
		insumoEntity.setImagem(insumo.getImagem());
		insumoEntity.setNome(insumo.getNome());
		insumoEntity.setPesoEmGramas(insumo.getPesoEmGramas());
		insumoEntity.setPreco(insumo.getPreco());
		insumoEntity.setQuantidade(insumo.getQuantidade());
		insumoEntity.setLanches(insumo.getLanches());
		
		return insumoEntity;
	
	}

}
