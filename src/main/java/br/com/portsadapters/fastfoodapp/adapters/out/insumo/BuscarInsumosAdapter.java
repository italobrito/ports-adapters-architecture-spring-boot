package br.com.portsadapters.fastfoodapp.adapters.out.insumo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.InsumoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.application.ports.out.insumo.BuscarInsumosOutputPort;

@Component
public class BuscarInsumosAdapter implements BuscarInsumosOutputPort {

	@Autowired
	private InsumoRepository insumoRepository;
	
	@Override
	public List<InsumoEntity> buscarTodos() {
		return insumoRepository.findAll();
	}

}
