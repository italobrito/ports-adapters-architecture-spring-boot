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
		lancheEntity.setTipoLanche(lanche.getTipoLanche());

		List<InsumoEntity> insumosEntity = new ArrayList<InsumoEntity>();

		for (Insumo insumo : lanche.getInsumos()) {
			InsumoEntity insumoEntity = new InsumoEntity();
			insumoEntity.setId(insumo.getId());
			insumoEntity.setNome(insumo.getNome());
			insumoEntity.setPreco(insumo.getPreco());
			insumoEntity.setQuantidade(insumo.getQuantidade());
			insumoEntity.setPesoEmGramas(insumo.getPesoEmGramas());
			insumosEntity.add(insumoEntity);
		}

		lancheEntity.setInsumos(insumosEntity);

		return lancheEntity;

	}

	public List<LancheEntity> paraLancheEntity(List<Lanche> lanches) {
		List<LancheEntity> lanchesEntity = new ArrayList<>();

		for (Lanche lanche : lanches) {
			LancheEntity lancheEntity = new LancheEntity();

			lancheEntity.setId(lanche.getId());
			lancheEntity.setNome(lanche.getNome());
			lancheEntity.setPreco(lanche.getPreco());
			lancheEntity.setTipoLanche(lanche.getTipoLanche());

			List<InsumoEntity> insumosEntity = new ArrayList<>();

			for (Insumo insumo : lanche.getInsumos()) {
				InsumoEntity insumoEntity = new InsumoEntity();
				insumoEntity.setId(insumo.getId());
				insumoEntity.setNome(insumo.getNome());
				insumoEntity.setPreco(insumo.getPreco());
				insumoEntity.setQuantidade(insumo.getQuantidade());
				insumoEntity.setPesoEmGramas(insumo.getPesoEmGramas());
				insumosEntity.add(insumoEntity);
			}

			lancheEntity.setInsumos(insumosEntity);
			lanchesEntity.add(lancheEntity);
		}

		return lanchesEntity;
	}

}
