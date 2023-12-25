package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Insumo;
import br.com.portsadapters.fastfoodapp.application.core.domain.Lanche;

@Component
public class LancheEntityMapper {
	
	public LancheEntity paraLancheEntity(Lanche lanche) {
		
		LancheEntity lancheEntity = new LancheEntity();
		
		lancheEntity.setId(lanche.getId());
		lancheEntity.setNome(lanche.getNome());
		lancheEntity.setPreco(lanche.getPreco());
		
        List<InsumoEntity> insumosEntity = new ArrayList<InsumoEntity>();
        
        for (Insumo insumo : lanche.getInsumos()) {
            InsumoEntity insumoEntity = new InsumoEntity();
            insumoEntity.setId(insumo.getId());
            insumoEntity.setNome(insumo.getNome());
            insumoEntity.setPreco(insumo.getPreco());
            insumosEntity.add(insumoEntity);
        }
		
		lancheEntity.setInsumos(insumosEntity);

		return lancheEntity;
		
	}

}