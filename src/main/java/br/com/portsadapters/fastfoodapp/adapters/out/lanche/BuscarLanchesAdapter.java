package br.com.portsadapters.fastfoodapp.adapters.out.lanche;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.LancheRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import br.com.portsadapters.fastfoodapp.application.ports.out.lanche.BuscarLanchesOutputport;

@Component
public class BuscarLanchesAdapter implements BuscarLanchesOutputport {

	@Autowired
	private LancheRepository lancheRepository;
	
	@Override
	public List<LancheEntity> buscarTodos() {
		return lancheRepository.findAll();
	}

}
