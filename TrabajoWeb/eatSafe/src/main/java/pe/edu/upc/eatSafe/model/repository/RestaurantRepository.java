package pe.edu.upc.eatSafe.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.eatSafe.model.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	List<Restaurant> findByNameAndAddress(String name, String address);
	List<Restaurant> findByName(String name) throws Exception;
	
}
