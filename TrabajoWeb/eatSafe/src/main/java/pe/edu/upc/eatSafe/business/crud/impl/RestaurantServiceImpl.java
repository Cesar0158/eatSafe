package pe.edu.upc.eatSafe.business.crud.impl;

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

}
