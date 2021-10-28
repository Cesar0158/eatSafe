package pe.edu.upc.eatSafe.business.crud.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.eatSafe.business.crud.RestaurantService;
import pe.edu.upc.eatSafe.model.entity.Restaurant;
import pe.edu.upc.eatSafe.model.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public JpaRepository<Restaurant, Integer> getJpaRepository() {
		return restaurantRepository;
	}
	
	@Override
	public List<Restaurant> findByNameAndAddress(String name, String address) throws Exception{
		return restaurantRepository.findByNameAndAddress(name, address);
	}
	
	@Override
	public List<Restaurant> findByName(String name) throws Exception{
		return restaurantRepository.findByName(name);
	}

}
