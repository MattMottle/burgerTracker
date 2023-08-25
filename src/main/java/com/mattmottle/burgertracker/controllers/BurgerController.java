package com.mattmottle.burgertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mattmottle.burgertracker.models.Burger;
import com.mattmottle.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	@Autowired
	private BurgerService burgerService;
	
	@GetMapping("/")
	public String home(Model model, @ModelAttribute("burger") Burger burger) {
		List<Burger> burgers = burgerService.readAllBurgers();
	     model.addAttribute("burgers", burgers);
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String addBurgerToDatabase(Model model, @Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		if (result.hasErrors()) { 
			List<Burger> burgers = burgerService.readAllBurgers();
		     model.addAttribute("burgers", burgers);
			//had to change newBurger to burger to allow error validation to work because of burger parameter for home.
			return "index.jsp"; 
		} 
		else {
			burgerService.createBurger(burger);
			return "redirect:/";
		}
	}
	
	@GetMapping("/{burgerId}")
	public String index(Model model, @PathVariable("burgerId") Long burgerId) {
		Burger burger = burgerService.findBurger(burgerId);
		model.addAttribute("burger", burger);
		return "burger.jsp";
	}
}
