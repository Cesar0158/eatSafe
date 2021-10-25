package pe.edu.upc.eatSafe.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.eatSafe.model.entity.Opinion;
import pe.edu.upc.eatSafe.model.repository.OpinionRepository;

@Named
@ApplicationScoped
public class OpinionRepositoryImpl implements OpinionRepository {

	@PersistenceContext(unitName="eatSafePU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public Optional<Opinion> findById(Integer id) throws Exception{
		return findById(id,Opinion.class);
	}
	
	@Override
	public List<Opinion> findAll() throws Exception{
		
		String jpql = "SELECT opinion FROM Opinion opinion";
		return findByQuery(Opinion.class,jpql);
	}
	
	@Override
	public List<Opinion> findByName(String name) throws Exception{
		String jpql = "SELECT r FROM Opinion r WHERE r.name LIKE '%" + name + "%'";
		System.out.println(jpql);
		return findByQuery(Opinion.class, jpql);
	}
}
