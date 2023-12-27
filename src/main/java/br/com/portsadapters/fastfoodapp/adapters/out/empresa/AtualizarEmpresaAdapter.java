package br.com.portsadapters.fastfoodapp.adapters.out.empresa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.EmpresaMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.EmpresaRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.EnderecoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;
import br.com.portsadapters.fastfoodapp.application.ports.out.empresa.AtualizarEmpresaOutputPort;

@Component
public class AtualizarEmpresaAdapter implements AtualizarEmpresaOutputPort {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EmpresaMapper empresaMapper;
	
	@Override
	public EmpresaEntity atualizar(Empresa empresa) {
		EmpresaEntity empresaEntity = empresaMapper.paraEmpresaEntiy(empresa);
		
		List<EnderecoEntity> enderecosEntityAlterado = enderecoRepository.saveAll(empresaEntity.getEnderecos());
		
		Optional<EmpresaEntity> empresaEntityEncontrado = empresaRepository.findById(empresaEntity.getId());
		
		if(empresaEntityEncontrado.isPresent()) {
			empresaEntity.setEnderecos(empresaEntityEncontrado.get().getEnderecos());
		}
		
		EmpresaEntity clienteEntityAlterado = empresaRepository.save(empresaEntity);
		
		clienteEntityAlterado.setEnderecos(enderecosEntityAlterado);
        
		return clienteEntityAlterado;
		
	}

}
