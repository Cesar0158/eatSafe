package pe.edu.upc.eatSafe.business.crud;

import java.util.List;

import pe.edu.upc.eatSafe.model.entity.Restaurant;

public interface RestaurantService extends CrudService<Restaurant, Integer> {
List<Restaurant> findByName(String name) throws Exception;
}
