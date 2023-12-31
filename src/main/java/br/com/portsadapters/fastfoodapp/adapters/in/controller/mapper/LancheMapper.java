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
		lancheResponse.setTipoLanche(lancheEntity.getTipoLanche());

		List<InsumoResponse> insumos = new ArrayList<>();

		if (lancheEntity.getInsumos() != null) {
			for (InsumoEntity insumoEntity : lancheEntity.getInsumos()) {

				InsumoResponse insumoCriado = new InsumoResponse();

				insumoCriado.setId(insumoEntity.getId());
				insumoCriado.setNome(insumoEntity.getNome());
				insumoCriado.setQuantidade(insumoEntity.getQuantidade());
				insumoCriado.setPesoEmGramas(insumoEntity.getPesoEmGramas());

				insumos.add(insumoCriado);
			}
		}

		lancheResponse.setInsumos(insumos);
		return lancheResponse;
	}

	public Lanche paraLanche(LancheRequest lancheRequest) {
		Lanche lanche = new Lanche();

		lanche.setId(lancheRequest.getId());
		lanche.setNome(lancheRequest.getNome());
		lanche.setPreco(lancheRequest.getPreco());
		lanche.setTipoLanche(lancheRequest.getTipoLanche());

		List<Insumo> insumos = new ArrayList<>();

		if (lancheRequest.getInsumos() != null) {
			for (InsumoRequest insumoRequest : lancheRequest.getInsumos()) {

				Insumo insumoCriado = new Insumo();

				insumoCriado.setId(insumoRequest.getId());
				insumoCriado.setNome(insumoRequest.getNome());
				insumoCriado.setPreco(insumoRequest.getPreco());
				insumoCriado.setQuantidade(insumoRequest.getQuantidade());
				insumoCriado.setImagem(insumoRequest.getImagem());
				insumoCriado.setPesoEmGramas(insumoRequest.getPesoEmGramas());

				insumos.add(insumoCriado);
			}
		}

		lanche.setInsumos(insumos);
		return lanche;
	}

	public List<Lanche> paraLanche(List<LancheRequest> lancheRequests) {
		List<Lanche> lanches = new ArrayList<>();

		for (LancheRequest lancheRequest : lancheRequests) {
			Lanche lanche = new Lanche();

			lanche.setId(lancheRequest.getId());
			lanche.setNome(lancheRequest.getNome());
			lanche.setPreco(lancheRequest.getPreco());
			lanche.setTipoLanche(lancheRequest.getTipoLanche());

			List<Insumo> insumos = new ArrayList<>();

			if (lancheRequest.getInsumos() != null) {
				for (InsumoRequest insumoRequest : lancheRequest.getInsumos()) {
					Insumo insumoCriado = new Insumo();

					insumoCriado.setId(insumoRequest.getId());
					insumoCriado.setNome(insumoRequest.getNome());
					insumoCriado.setPreco(insumoRequest.getPreco());
					insumoCriado.setQuantidade(insumoRequest.getQuantidade());
					insumoCriado.setImagem(insumoRequest.getImagem());
					insumoCriado.setPesoEmGramas(insumoRequest.getPesoEmGramas());

					insumos.add(insumoCriado);
				}
			}

			lanche.setInsumos(insumos);
			lanches.add(lanche);
		}

		return lanches;
	}

	public LancheEntity paraLancheEntity(Lanche lanche) {
		LancheEntity lancheEntity = new LancheEntity();

		lancheEntity.setId(lanche.getId());
		lancheEntity.setNome(lanche.getNome());
		lancheEntity.setPreco(lanche.getPreco());
		lancheEntity.setTipoLanche(lanche.getTipoLanche());

		List<InsumoEntity> insumos = new ArrayList<>();

		if (lanche.getInsumos() != null) {
			for (Insumo insumo : lanche.getInsumos()) {

				InsumoEntity insumoCriado = new InsumoEntity();

				insumoCriado.setId(insumo.getId());
				insumoCriado.setNome(insumo.getNome());
				insumoCriado.setPreco(insumo.getPreco());
				insumoCriado.setQuantidade(insumo.getQuantidade());
				insumoCriado.setImagem(insumo.getImagem());
				insumoCriado.setPesoEmGramas(insumo.getPesoEmGramas());

				insumos.add(insumoCriado);
			}
		}

		lancheEntity.setInsumos(insumos);
		return lancheEntity;
	}

}
