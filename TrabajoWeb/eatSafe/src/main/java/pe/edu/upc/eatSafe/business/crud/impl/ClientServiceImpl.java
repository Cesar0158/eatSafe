package pe.edu.upc.eatSafe.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.eatSafe.business.crud.ClientService;
import pe.edu.upc.eatSafe.model.entity.Client;
import pe.edu.upc.eatSafe.model.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
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
