package com.dojosandninjasfinal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dojosandninjasfinal.models.Dojo;
import com.dojosandninjasfinal.models.Ninja;
import com.dojosandninjasfinal.services.DojoService;
import com.dojosandninjasfinal.services.NinjaService;



@Controller
@RequestMapping("/ninja")
public class NinjaController {
	@Autowired
	private NinjaService nService;
	
	@Autowired
	private DojoService dService;
	
	
	@GetMapping("/detail")
	public String nDashBoard(
			Model model, 
			@ModelAttribute("ninja") Ninja ninja,
			@ModelAttribute("dojo") Dojo dojo
			)  {
		
		List<Ninja> ninjas = nService.getall();
		model.addAttribute("ninjas", ninjas);
		List<Dojo> dojos = dService.getall();
		model.addAttribute("dojos", dojos);
		return "Ninja.jsp";
	}
	@PostMapping("/create")
	public String pCreateNinja(
			Model model,
			@ModelAttribute ("dojo") Dojo dojo,
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result
			) {
	if(result.hasErrors()) {
		 List<Ninja> ninjas = nService.getall();
		 List<Dojo> dojos = dService.getall();
		 model.addAttribute("ninjas", ninjas);
		 model.addAttribute("dojos", dojos);
		 return "Ninja.jsp";
	}
	
	nService.createorupdate(ninja);
	
	return "redirect:/ninja/detail";
}
	
	 
	@PostMapping("/enroll")
	public String dEnroll(
			@RequestParam("ninjaId") Long ninjaId,
			@RequestParam("dojoId") Long dojoId
			) {
		Ninja n = nService.getOne(ninjaId);
		Dojo d = dService.getOne(dojoId);
		
		d.setOneNinja(n);
		System.out.println(d.getNinjas());
		dService.createorupdate(d);
		 
		return "redirect:/dojo/detail";
	}
	
	
	
}
