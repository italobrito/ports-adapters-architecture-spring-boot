package br.com.portsadapters.fastfoodapp.adapters.out.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.ClienteRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.ClienteEntityMapper;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.ports.out.cliente.InserirClienteOutputPort;

@Component
public class InserirClienteAdapter implements InserirClienteOutputPort {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteEntityMapper clienteEntityMapper;

	@Override
	public ClienteEntity inserir(Cliente cliente) {
		ClienteEntity clienteEntity = clienteEntityMapper.paraClienteEntity(cliente);
		ClienteEntity clienteSalvo = clienteRepository.save(clienteEntity);
		clienteEntity.setId(clienteSalvo.getId());
		return clienteEntity;
	}
	
    @Override
    public List<ClienteEntity> inserirTodos(List<Cliente> clientes) {
        List<ClienteEntity> clientesEntity = clienteEntityMapper.paraClienteEntity(clientes);
        List<ClienteEntity> savedEntities = clienteRepository.saveAll(clientesEntity);

        for (int i = 0; i < clientes.size(); i++) {
            clientes.get(i).setId(savedEntities.get(i).getId());
        }

        return savedEntities;
    }
	
}
