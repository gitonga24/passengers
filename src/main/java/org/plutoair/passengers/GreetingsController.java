package org.plutoair.passengers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingsController {

	
	@Resource
	public CustomerRepository customerRepo;
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="Ephraim", required=true, defaultValue="gitonga") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/greetings")
	public String greetings(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/customers")
	public String findAllCustomers(Model model) {
		model.addAttribute("customers", customerRepo.findAll()); 
		return "customers";
	}
	
}
