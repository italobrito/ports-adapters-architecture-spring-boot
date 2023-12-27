package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.InsumoRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Insumo;

@Component
public class InsumoMapper {
	
	public Insumo paraInsumo(InsumoRequest insumoRequest) {
		Insumo insumo = new Insumo();
		insumo.setId(insumoRequest.getId());
		insumo.setNome(insumoRequest.getNome());
		insumo.setPesoEmGramas(insumoRequest.getPesoEmGramas());
		insumo.setQuantidade(insumoRequest.getQuantidade());
		insumo.setPreco(insumoRequest.getPreco());
		return insumo;
	}
	
	public Insumo paraInsumo(InsumoEntity insumoEntity) {
		Insumo insumo = new Insumo();
		insumo.setId(insumoEntity.getId());
		insumo.setNome(insumoEntity.getNome());
		insumo.setPesoEmGramas(insumoEntity.getPesoEmGramas());
		insumo.setQuantidade(insumoEntity.getQuantidade());
		insumo.setPreco(insumoEntity.getPreco());
		return insumo;
	}
	
	public InsumoEntity paraInsumoEntity(Insumo insumo) {
		InsumoEntity insumoEntity = new InsumoEntity();
		insumoEntity.setId(insumo.getId());
		insumoEntity.setNome(insumo.getNome());
		insumoEntity.setPesoEmGramas(insumo.getPesoEmGramas());
		insumoEntity.setQuantidade(insumo.getQuantidade());
		insumoEntity.setPreco(insumo.getPreco());
		insumoEntity.setLanches(insumo.getLanches());
		return insumoEntity;
	}

}
