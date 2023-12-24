package br.com.portsadapters.fastfoodapp.adapters.out.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.EmpresaRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.application.ports.out.empresa.BuscarEmpresasOutputPort;

@Component
public class BuscarEmpresasAdapter implements BuscarEmpresasOutputPort {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public List<EmpresaEntity> buscarTodos() {
		return empresaRepository.findAll();
	}

}
