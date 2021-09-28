package pe.edu.upc.eatSafe.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.eatSafe.business.crud.RestaurantService;
import pe.edu.upc.eatSafe.model.entity.Restaurant;

@Named("restaurantView")
@ViewScoped
public class RestaurantView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Restaurant> restaurants;
	private Restaurant restaurantSelected;
	private List<Restaurant> restaurantsSelected;

	@Inject
	private RestaurantService restaurantService;

	@PostConstruct
	public void init() {
		restaurantsSelected = new ArrayList<>();
		try {
			restaurants = restaurantService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean hasRestaurantsSelected() {
		if (restaurantsSelected.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean hasRestaurantSelected() {
		if (restaurantsSelected.size() == 1) {
			return true;
		}
		return false;
	}

	public void createNew() {
		restaurantSelected = new Restaurant();
	}

	public void editRestaurantSelected() {
		restaurantSelected = restaurantsSelected.get(0);
	}

	public void saveRestaurant() {
		try {
			System.out.println(restaurantSelected.getId());
			System.out.println(restaurantSelected.getName());
			System.out.println(restaurantSelected.getAddress());
			System.out.println(restaurantSelected.getCapacity());
			System.out.println(restaurantSelected.getPhone());
			System.out.println(restaurantSelected.getOpinions());
			System.out.println(restaurantSelected.getTables());

			if (restaurantSelected.getId() == null) {
				restaurantService.create(restaurantSelected);
				restaurants.add(restaurantSelected);
			} else {
				restaurantService.update(restaurantSelected);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('restaurantDialog').hide()");
		PrimeFaces.current().ajax().update("restaurantDataTable");
	}

	public void deleteRestaurant() {
		try {
			if (restaurantSelected.getId() > 0) {
				restaurantService.deleteById(restaurantSelected.getId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	public Restaurant getRestaurantSelected() {
		return restaurantSelected;
	}

	public void setRestaurantSelected(Restaurant restaurantSelected) {
		this.restaurantSelected = restaurantSelected;
	}

	public List<Restaurant> getRestaurantsSelected() {
		return restaurantsSelected;
	}

	public void setRestaurantsSelected(List<Restaurant> restaurantsSelected) {
		this.restaurantsSelected = restaurantsSelected;
	}
}
