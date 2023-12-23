package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;

@Component
public class EmpresaEntityMapper {
	
	@Autowired
	private EnderecoEntityMapper enderecoEntityMapper;
	
    public EmpresaEntity paraEmpresaEntity(Empresa empresa) {
        EmpresaEntity empresaEntity = new EmpresaEntity();
        empresaEntity.setId(empresa.getId());
        empresaEntity.setNome(empresa.getNome());
        empresaEntity.setCnpj(empresa.getCnpj());
        empresaEntity.setEnderecos(enderecoEntityMapper.paraEnderecosEntity(empresa.getEnderecos(), empresaEntity));
        empresaEntity.setAtivo(empresa.getAtivo());
        return empresaEntity;
    }

}
