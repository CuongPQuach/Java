package com.fruityloop.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fruityloop.models.Item;

@Controller
public class MainController {
	
	
	
	
	@GetMapping("/") 
	public String FruitfDisplay(Model model) {
		ArrayList<Item> fruits = new ArrayList<Item>();
		fruits.add(new Item( "Kiwi", 1.5));
		fruits.add(new Item( "Mango", 2.0));
		fruits.add(new Item( "Goji Berries", 4.0));
		fruits.add(new Item( "Guava", 0.75));
        model.addAttribute("fruitsFromFruityloopController", fruits);

		
		return "fruityloop.jsp";
	}
	
	
}
