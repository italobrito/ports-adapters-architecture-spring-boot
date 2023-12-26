package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
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
	
	  public List<InsumoEntity> paraInsumoEntity(List<Insumo> insumos) {
	        List<InsumoEntity> insumosEntity = new ArrayList<>();

	        for (Insumo insumo : insumos) {
	            InsumoEntity insumoEntity = new InsumoEntity();

	            insumoEntity.setId(insumo.getId());
	            insumoEntity.setImagem(insumo.getImagem());
	            insumoEntity.setNome(insumo.getNome());
	            insumoEntity.setPesoEmGramas(insumo.getPesoEmGramas());
	            insumoEntity.setPreco(insumo.getPreco());
	            insumoEntity.setQuantidade(insumo.getQuantidade());
	            insumoEntity.setLanches(insumo.getLanches());

	            insumosEntity.add(insumoEntity);
	        }

	        return insumosEntity;
	    }
	  
	  public List<InsumoEntity> paraInsumoEntity(List<Insumo> insumos, LancheEntity lancheEntity) {
	        List<InsumoEntity> insumosEntity = new ArrayList<>();

	        for (Insumo insumo : insumos) {
	            InsumoEntity insumoEntity = new InsumoEntity();

	            insumoEntity.setId(insumo.getId());
	            insumoEntity.setImagem(insumo.getImagem());
	            insumoEntity.setNome(insumo.getNome());
	            insumoEntity.setPesoEmGramas(insumo.getPesoEmGramas());
	            insumoEntity.setPreco(insumo.getPreco());
	            insumoEntity.setQuantidade(insumo.getQuantidade());
	            
	            List<LancheEntity> listaLanchesEntity = new ArrayList<>();
	            listaLanchesEntity.add(lancheEntity);
	            
	            insumoEntity.setLanches(listaLanchesEntity);

	            insumosEntity.add(insumoEntity);
	        }

	        return insumosEntity;
	    }

}
