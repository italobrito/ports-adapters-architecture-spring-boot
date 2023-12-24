package br.com.portsadapters.fastfoodapp.adapters.out.empresa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.EmpresaRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.application.ports.out.empresa.BuscarEmpresaPorIdOutputPort;

@Component
public class BuscarEmpresaPorIdAdapter implements BuscarEmpresaPorIdOutputPort {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public Optional<EmpresaEntity> buscarPorId(Long id) {
		EmpresaEntity empresaEntity = empresaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Empresa não encontrada com o ID fornecido: " + id));
		return Optional.ofNullable(empresaEntity);
	}

}
