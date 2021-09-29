package pe.edu.upc.eatSafe.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
	private Restaurant restaurantSearch;

	@Inject
	private RestaurantService restaurantService;

	@PostConstruct
	public void init() {
		restaurantsSelected = new ArrayList<>();
		restaurantSearch = new Restaurant();
		getAllRestaurant();
		
	}

	public boolean hasRestaurantsSelected() { /* Manipulacion de interfaz has=(seleccionar cuadritos en la vista) */
		if (restaurantsSelected.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean hasRestaurantSelected() {
		if (restaurantsSelected.size() == 1) { /* para seleccionar solo 2 o 1 elemento */
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
			this.restaurants.remove(restaurantSelected);
			restaurantService.deleteById(this.restaurantSelected.getId());
			this.restaurantSelected = null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
		//PrimeFaces.current().ajax().update("form:messages","regionDataTable");
	}

	public void searchRestaurant() {
		try	{
			restaurants = restaurantService.findByName(restaurantSearch.getName());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllRestaurant() {
		try {
			restaurants = restaurantService.getAll();
		} catch (Exception e) {
			// TODO: handle exception
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
	
	public Restaurant getRestaurantSearch() {
		return restaurantSearch;
	}
	public void setRestaurantSearch(Restaurant restaurantSearch) {
		this.restaurantSearch = restaurantSearch;
	}
}
