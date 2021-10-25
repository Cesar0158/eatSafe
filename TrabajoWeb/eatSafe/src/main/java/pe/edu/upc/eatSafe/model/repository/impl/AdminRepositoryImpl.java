package pe.edu.upc.eatSafe.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.eatSafe.model.entity.Admin;
import pe.edu.upc.eatSafe.model.repository.AdminRepository;

public class AdminRepositoryImpl implements AdminRepository {

	@PersistenceContext(unitName = "eatSafePU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}


	@Override
	public Optional<Admin> findById(Integer id) throws Exception {
		return findById(id,Admin.class);
	}

	@Override
	public List<Admin> findAll() throws Exception {
		String jpql = "SELECT admin from Admin admin"; 
		return findByQuery(Admin.class, jpql);
	}

	@Override
	public List<Admin> findByEmail(String email) throws Exception {
		String jpql = "SELECT a FROM Admin a WHERE a.email like '%" + email + "%'";
		System.out.println(jpql);
		return findByQuery(Admin.class, jpql);
	}

}
