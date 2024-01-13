package br.com.portsadapters.fastfoodapp.adapters.out.empresa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.ClienteRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.EmpresaRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.EmpresaEntityMapper;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.core.domain.Empresa;
import br.com.portsadapters.fastfoodapp.application.ports.out.empresa.InserirEmpresaOutputPort;

@Component
public class InserirEmpresaAdapter implements InserirEmpresaOutputPort {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EmpresaEntityMapper empresaEntityMapper;

	@Override
	public EmpresaEntity inserir(Empresa empresa) {

		EmpresaEntity empresaEntity = empresaEntityMapper.paraEmpresaEntity(empresa);
		EmpresaEntity empresaCriada = empresaRepository.save(empresaEntity);

		empresaEntity.setId(empresaCriada.getId());

		if (empresa.getClientes() != null && !empresa.getClientes().isEmpty()) {
			for (Cliente cliente : empresa.getClientes()) {
				ClienteEntity clienteEntity = clienteRepository.findById(cliente.getId()).orElseThrow(
						() -> new RuntimeException("Cliente não encontrado com o ID fornecido: " + cliente.getId()));
				clienteEntity.setEmpresa(empresaCriada);
				ClienteEntity clienteAlterado = clienteRepository.save(clienteEntity);
				List<ClienteEntity> listaClientes = new ArrayList<ClienteEntity>();
				listaClientes.add(clienteAlterado);
				empresaCriada.setClientes(listaClientes);

			}
		}

		return empresaCriada;
	}

}
