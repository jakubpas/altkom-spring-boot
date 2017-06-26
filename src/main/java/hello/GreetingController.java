package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

	@Autowired
	ProductRepo repo;

	@RequestMapping("/greeting")
	public String greeting(Model model) {

		model.addAttribute("products", repo.findAll());

		return "greeting";
	}

}
