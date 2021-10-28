package pe.edu.upc.eatSafe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.eatSafe.business.crud.RestaurantService;
import pe.edu.upc.eatSafe.model.entity.Restaurant;
import pe.edu.upc.eatSafe.utils.RestaurantSearch;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("restaurant")
	public String searchRestaurants(Model model, @ModelAttribute("restaurantSearch") RestaurantSearch restaurantSearch) {

		List<Restaurant> restaurants = new ArrayList<>();
		
		try {
			restaurants = restaurantService.findByName(restaurantSearch.getName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		model.addAttribute("restaurantSearch", restaurantSearch);
		model.addAttribute("restaurants", restaurants);		
		
		return "searchs/view-restaurants";
	}
}
