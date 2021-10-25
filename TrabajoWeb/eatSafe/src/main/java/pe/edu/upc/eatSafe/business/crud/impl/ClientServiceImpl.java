package pe.edu.upc.eatSafe.business.crud.impl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.eatSafe.business.crud.ClientService;
import pe.edu.upc.eatSafe.model.entity.Client;
import pe.edu.upc.eatSafe.model.repository.ClientRepository;
import pe.edu.upc.eatSafe.model.repository.JpaRepository;

public class ClientServiceImpl implements ClientService {

	@Inject
	private ClientRepository clientRepository;
	
	@Override
	public JpaRepository<Client, Integer> getJpaRepository() {
		return clientRepository;
	}

	@Override
	public List<Client> findByEmail(String email) throws Exception {
		return clientRepository.findByEmail(email);
	}

}
