package pe.edu.upc.eatSafe.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.eatSafe.model.entity.Category;
import pe.edu.upc.eatSafe.model.repository.CategoryRepository;

public class CategoryRepositoryImpl implements CategoryRepository{

	@PersistenceContext(unitName="eatSafePU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public Optional<Category> findById(Integer id) throws Exception{
		return findById(id,Category.class);
	}
	
	@Override
	public List<Category> findAll() throws Exception{
		
		String jpql = "SELECT category FROM Category category";
		return findByQuery(Category.class, jpql);
	}
	
	@Override
	public List<Category> findByName(String name) throws Exception{
		String jpql = "SELECT r FROM Category r WHERE r.name LIKE '%" + name +"%'";
		System.out.println(jpql);
		return findByQuery(Category.class, jpql);
	}
}
