package br.com.portsadapters.fastfoodapp.adapters.out.insumo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Insumo;
import br.com.portsadapters.fastfoodapp.application.ports.out.insumo.AtualizarInsumoOutputPort;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.InsumoMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.InsumoRepository;

@Component
public class AtualizarInsumoAdapter implements AtualizarInsumoOutputPort {
	
	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private InsumoMapper insumoMapper;

	@Override
	public InsumoEntity atualizar(Insumo insumo) {
		InsumoEntity insumoEntity = insumoMapper.paraInsumoEntity(insumo);
		return insumoRepository.save(insumoEntity);
	}

}
