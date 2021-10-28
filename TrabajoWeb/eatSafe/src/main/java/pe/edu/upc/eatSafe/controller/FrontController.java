package pe.edu.upc.eatSafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.eatSafe.utils.RestaurantSearch;

@Controller
@RequestMapping("/")
@SessionAttributes("{restaurantSearch}")
public class FrontController {

	@GetMapping
	public String home(Model model) {
		RestaurantSearch restaurantSearch = new RestaurantSearch();
		model.addAttribute("restaurantSearch", restaurantSearch);
		return "home";
	}
	
	@GetMapping("inicio")	// request
	public String index() {
		return "ejemplo";
	}
	
	@GetMapping("inicio2")	// request
	public String inicio2() {
		return "ejemplo2";
	}
	
	@GetMapping("inicio2-sub")	// request
	public String inicio3() {
		return "ejemplo2";
	}
	
}
