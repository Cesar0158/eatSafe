package pe.edu.upc.eatSafe.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.eatSafe.model.entity.Restaurant;
import pe.edu.upc.eatSafe.model.repository.RestaurantRepository;

@Named
@ApplicationScoped
public class RestaurantRepositoryImpl implements RestaurantRepository {

	@PersistenceContext(unitName = "eatSafePU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public Optional<Restaurant> findById(Integer id) throws Exception{
		return findById(id,Restaurant.class);
	}
	
	@Override
	public List<Restaurant> findAll() throws Exception{
		
		String jpql = "SELECT restaurant FROM Restaurant restaurant";
		return findAll(Restaurant.class, jpql);
	}
	
}
