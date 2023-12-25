package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.InsumoRequest;
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

}
