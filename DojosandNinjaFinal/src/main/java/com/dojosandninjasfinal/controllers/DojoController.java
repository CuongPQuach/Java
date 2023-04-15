 package com.dojosandninjasfinal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dojosandninjasfinal.models.Dojo;
import com.dojosandninjasfinal.models.Ninja;
import com.dojosandninjasfinal.services.DojoService;
import com.dojosandninjasfinal.services.NinjaService;

@Controller
@RequestMapping("/dojo")
public class DojoController {
	@Autowired
	private DojoService dService;
	
	@Autowired
	private NinjaService nService;
	
	@GetMapping("/detail")
	public String dDashBoard(Model model, @ModelAttribute("dojo") Dojo dojo)  {
		List<Dojo> dojos = dService.getall();
		model.addAttribute("dojos", dojos);
		return "Dojo.jsp";
	}
	
	

//	create
	@PostMapping("/create")
	public String pCreateDojo(
			Model model,
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result
			) {
	if(result.hasErrors()) {
		 List<Dojo> dojos = dService.getall();
		 model.addAttribute("dojos", dojos); 
		 return "Dojo.jsp";
	}
	
	
	dService.createorupdate(dojo);
	
	return "redirect:/dojo/detail";
}
	
//	single Detail
	@GetMapping("/detail/{id}")
	public String rDojoDetails(
			@PathVariable("id") Long dojoId,
			Model model
			) {
		Dojo pendingDojo = dService.getOne(dojoId);
		model.addAttribute("dojo", dService.getOne(dojoId));
		
//		Query for Mapping
		List<Ninja> ninjas = nService.findNinjaByDojo(pendingDojo);
		model.addAttribute("Ninjas", ninjas);
		
		return "DojoDetail.jsp";
	}
	
	
	
	
	
//	edit 
	@PutMapping("/edit/{id}")
	public String peditExpend(
			@PathVariable("id") Long dojoId,
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result,		
			Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("dojo", dService.getOne(dojoId));

			return "DojoDetail.jsp";
		}
		dService.createorupdate(dojo);
		return String.format("redirect:/dojo/detail/%s", dojoId);
		
	}
	
	
	
	
	
	
	
	
	
	
//	delete
	@DeleteMapping("/delete/{id}")
	public String detroy(@PathVariable("id") Long dojoId) {
		dService.deleteDojo(dojoId);
		return "redirect:/dojo/detail";
	}
	
	
	
}
