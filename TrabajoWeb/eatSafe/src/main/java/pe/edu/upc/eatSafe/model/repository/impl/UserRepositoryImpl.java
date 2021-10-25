package pe.edu.upc.eatSafe.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.eatSafe.model.entity.User;
import pe.edu.upc.eatSafe.model.repository.UserRepository;

@Named
@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext(unitName = "eatSafePU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<User> findById(Integer id) throws Exception {
		return findById(id,User.class);
	}

	@Override
	public List<User> findAll() throws Exception {
		String jpql = "SELECT user FROM User user";
		return findByQuery(User.class, jpql);
	}

	@Override
	public List<User> findByEmail(String email) throws Exception {
		String jpql = "SELECT u FROM User u WHERE u.email LIKE '%" + email +"%'";
		System.out.println(jpql);
		return findByQuery(User.class, jpql);
	}

}
