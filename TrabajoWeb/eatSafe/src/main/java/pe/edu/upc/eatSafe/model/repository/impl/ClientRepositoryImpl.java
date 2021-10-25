package pe.edu.upc.eatSafe.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.eatSafe.model.entity.Client;
import pe.edu.upc.eatSafe.model.repository.ClientRepository;

public class ClientRepositoryImpl implements ClientRepository {

	@PersistenceContext(unitName = "eatSafePU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<Client> findById(Integer id) throws Exception {
		return findById(id,Client.class);
	}

	@Override
	public List<Client> findAll() throws Exception {
		String jpql = "SELECT client FROM Client client";
		return findByQuery(Client.class, jpql);
	}

	@Override
	public List<Client> findByEmail(String email) throws Exception {
		String jpql = "SELECT c FROM Client c WHERE c.email LIKE '%" + email + "%'";
		System.out.println(jpql);
		return findByQuery(Client.class, jpql);
	}

}
