package pe.edu.upc.eatSafe.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.eatSafe.business.crud.RestaurantService;
import pe.edu.upc.eatSafe.model.entity.Restaurant;
import pe.edu.upc.eatSafe.model.repository.JpaRepository;
import pe.edu.upc.eatSafe.model.repository.RestaurantRepository;


@Named
@ApplicationScoped
public class RestaurantServiceImpl implements RestaurantService{

	@Inject
	private RestaurantRepository restaurantRepository;
	
	@Override
	public JpaRepository<Restaurant, Integer> getJpaRepository() {
		return restaurantRepository;
	}
	
	@Override
	public List<Restaurant> findByName(String name) throws Exception{
		return restaurantRepository.findByName(name);
	}

}
