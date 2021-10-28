package pe.edu.upc.eatSafe.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.eatSafe.business.crud.RestaurantService;
import pe.edu.upc.eatSafe.model.entity.Restaurant;

@Controller
@RequestMapping("/restaurants")
@SessionAttributes("restaurant")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;

	@GetMapping
	public String list(Model model) {
		try {
			List<Restaurant> restaurants = restaurantService.getAll();
			model.addAttribute("restaurants", restaurants);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "restaurants/list";
	}

	@GetMapping("new")
	public String newRestaurant(Model model) {
		try {
			model.addAttribute("restaurant", new Restaurant());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "restaurants/new";
	}

	@PostMapping("saveNew")
	public String saveNew(Model model, @Valid @ModelAttribute("restaurant") Restaurant restaurant, BindingResult result) {
		if (result.hasErrors()) {

		}

		System.out.println(restaurant.getName());
		System.out.println(restaurant.getAddress());
		System.out.println(restaurant.getCapacity());
		System.out.println(restaurant.getPhone());
		try {
			Restaurant restaurantSaved = restaurantService.create(restaurant);
			model.addAttribute("restaurant", restaurantSaved);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "restaurants/view";
	}

	@GetMapping("{id}/edit")
	public String edit(Model model, @PathVariable("id") Integer id) {
		try {
			if (restaurantService.existsById(id)) {
				Optional<Restaurant> optional = restaurantService.findById(id);
				model.addAttribute("country", optional.get());
				
			} else {
				return "redirect:/restaurants";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "restaurants/edit";
	}

	@PostMapping("saveedit")
	public String saveEdit(Model model, @ModelAttribute("restaurant") Restaurant restaurant) {
		System.out.println(restaurant.getName());
		System.out.println(restaurant.getAddress());
		System.out.println(restaurant.getCapacity());
		System.out.println(restaurant.getPhone());
		try {
			Restaurant restaurantSaved = restaurantService.update(restaurant);
			model.addAttribute("restaurant", restaurantSaved);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "restaurants/view";
	}

	@GetMapping("{id}/del")
	public String delete(Model model, @PathVariable("id") Integer id) {
		try {
			if (restaurantService.existsById(id)) {
				restaurantService.deleteById(id);
			} else {
				return "redirect:/restaurants";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "redirect:/restaurants";
	}

}
