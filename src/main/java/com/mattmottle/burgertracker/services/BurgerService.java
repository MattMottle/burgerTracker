package com.mattmottle.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mattmottle.burgertracker.models.Burger;
import com.mattmottle.burgertracker.repositories.BurgerRepository;


@Service
public class BurgerService {
	
		private final BurgerRepository burgerRepository; 
		
		public BurgerService(BurgerRepository burgerRepository) {
			this.burgerRepository = burgerRepository;
		}

		// Create a burger
		public Burger createBurger(Burger newBurger) {
			return burgerRepository.save(newBurger);
		}
		
		// Read all burgers
		public List<Burger> readAllBurgers() {
			return burgerRepository.findAll();
		}
		// Read one burger
		public Burger findBurger(Long id) {
	        Optional<Burger> optionalBurger = burgerRepository.findById(id);
	        if(optionalBurger.isPresent()) {
	            return optionalBurger.get();
	        } else {
	            return null;
	        }
	    }
		
		
}
