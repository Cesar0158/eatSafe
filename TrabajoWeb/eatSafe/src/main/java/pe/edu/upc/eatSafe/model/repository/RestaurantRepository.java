package pe.edu.upc.eatSafe.model.repository;

import java.util.List;

import pe.edu.upc.eatSafe.model.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	List<Restaurant> findByName(String name) throws Exception;
}
