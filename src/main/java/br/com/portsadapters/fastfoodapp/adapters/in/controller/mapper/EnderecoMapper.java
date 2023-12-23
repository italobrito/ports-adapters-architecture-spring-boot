package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.EnderecoRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Endereco;

@Component
public class EnderecoMapper {
	
    public Endereco paraEndereco(EnderecoRequest enderecoRequest) {
        Endereco endereco = new Endereco();
        endereco.setRua(enderecoRequest.getRua());
        endereco.setCep(enderecoRequest.getCep());
        endereco.setNumero(enderecoRequest.getNumero());
        endereco.setComplemento(enderecoRequest.getComplemento());
        return endereco;
    }
    
    public EnderecoEntity paraEnderecoEntity(EnderecoRequest enderecoRequest) {
    	EnderecoEntity enderecoEntity = new EnderecoEntity();
    	enderecoEntity.setRua(enderecoRequest.getRua());
    	enderecoEntity.setCep(enderecoRequest.getCep());
        enderecoEntity.setNumero(enderecoRequest.getNumero());
        enderecoEntity.setComplemento(enderecoRequest.getComplemento());
        return enderecoEntity;
    }
    
    public List<EnderecoEntity> paraListaEnderecoEntity(List<EnderecoRequest> enderecosRequest) {
        List<EnderecoEntity> enderecosEntity = new ArrayList<>();
        
        for (EnderecoRequest enderecoRequest : enderecosRequest) {
            EnderecoEntity enderecoEntity = new EnderecoEntity();
            enderecoEntity.setRua(enderecoRequest.getRua());
            enderecoEntity.setCep(enderecoRequest.getCep());
            enderecoEntity.setNumero(enderecoRequest.getNumero());
            enderecoEntity.setComplemento(enderecoRequest.getComplemento());
            enderecosEntity.add(enderecoEntity);
        }
        
        return enderecosEntity;
    }
    
    public EnderecoRequest paraEnderecoRequest(Endereco endereco) {
        EnderecoRequest enderecoRequest = new EnderecoRequest();
        enderecoRequest.setRua(endereco.getRua());
        enderecoRequest.setCep(endereco.getCep());
        enderecoRequest.setNumero(endereco.getNumero());
        enderecoRequest.setComplemento(endereco.getComplemento());
        return enderecoRequest;
    }
   
    public List<Endereco> paraListaEndereco(List<EnderecoRequest> listaEnderecoRequest) {
        List<Endereco> listaEndereco = new ArrayList<>();
        for (EnderecoRequest enderecoRequest : listaEnderecoRequest) {
            Endereco endereco = new Endereco();
            endereco.setRua(enderecoRequest.getRua());
            endereco.setCep(enderecoRequest.getCep());
            endereco.setNumero(enderecoRequest.getNumero());
            endereco.setComplemento(enderecoRequest.getComplemento());
            listaEndereco.add(endereco);
        }
        return listaEndereco;
    }
    
    public List<EnderecoEntity> paraEnderecoEntity(List<Endereco> listaEndereco) {
        List<EnderecoEntity> listaEnderecoEntity = new ArrayList<>();
        for (Endereco endereco : listaEndereco) {
            EnderecoEntity enderecoEntity = new EnderecoEntity();
            enderecoEntity.setRua(endereco.getRua());
            enderecoEntity.setCep(endereco.getCep());
            enderecoEntity.setNumero(endereco.getNumero());
            enderecoEntity.setComplemento(endereco.getComplemento());
            listaEnderecoEntity.add(enderecoEntity);
        }
        return listaEnderecoEntity;
    }

    public List<EnderecoRequest> paraListaEnderecoRequest(List<Endereco> listaEndereco) {
        List<EnderecoRequest> listaEnderecoRequest = new ArrayList<>();
        for (Endereco endereco : listaEndereco) {
            EnderecoRequest enderecoRequest = new EnderecoRequest();
            enderecoRequest.setRua(endereco.getRua());
            enderecoRequest.setCep(endereco.getCep());
            enderecoRequest.setNumero(endereco.getNumero());
            enderecoRequest.setComplemento(endereco.getComplemento());
            listaEnderecoRequest.add(enderecoRequest);
        }
        return listaEnderecoRequest;
    }
    
    
}
