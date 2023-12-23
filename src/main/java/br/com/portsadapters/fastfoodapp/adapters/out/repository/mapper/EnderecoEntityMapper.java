package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Endereco;

@Component
public class EnderecoEntityMapper {
	
    public List<EnderecoEntity> paraEnderecosEntity(List<Endereco> enderecos, EmpresaEntity empresaEntity) {
        List<EnderecoEntity> enderecosEntity = new ArrayList<>();
        for (Endereco endereco : enderecos) {
            EnderecoEntity enderecoEntity = new EnderecoEntity();
            enderecoEntity.setRua(endereco.getRua());
            enderecoEntity.setCep(endereco.getCep());
            enderecoEntity.setNumero(endereco.getNumero());
            enderecoEntity.setComplemento(endereco.getComplemento());
            enderecoEntity.setEmpresa(empresaEntity);
            enderecosEntity.add(enderecoEntity);
        }
        return enderecosEntity;
    }

}
