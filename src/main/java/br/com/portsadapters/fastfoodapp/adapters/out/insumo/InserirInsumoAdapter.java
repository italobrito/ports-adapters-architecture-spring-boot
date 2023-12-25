package br.com.portsadapters.fastfoodapp.adapters.out.insumo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.InsumoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.InsumoEntityMapper;
import br.com.portsadapters.fastfoodapp.application.core.domain.Insumo;
import br.com.portsadapters.fastfoodapp.application.ports.out.insumo.InserirInsumoOutputPort;

@Component
public class InserirInsumoAdapter implements InserirInsumoOutputPort {
	
	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private InsumoEntityMapper insumoEntityMapper;

	@Override
	public InsumoEntity inserir(Insumo insumo) {
		InsumoEntity insumoEntity = insumoEntityMapper.paraInsumoEntity(insumo);
		InsumoEntity insumoSalvo = insumoRepository.save(insumoEntity);
		insumoEntity.setId(insumoSalvo.getId());
		return insumoEntity;
	}

}
