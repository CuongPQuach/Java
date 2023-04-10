package com.SaveTravel.controllers;

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

import com.SaveTravel.models.Expend;
import com.SaveTravel.services.ExpendService;

@Controller
@RequestMapping("/")

public class ExpendController {
	@Autowired
	private ExpendService eService;
	
	
	@GetMapping("/expends")
		public String rDashBoard(Model model, @ModelAttribute("expend") Expend expend)  {
			List<Expend> expends = eService.getall();
			model.addAttribute("expends", expends);
			return "dashboard.jsp";
		}
	
	
	@PostMapping("/create")
		public String pCreateExpend(
				@Valid @ModelAttribute("expend") Expend expend,
				BindingResult result,
				Model model
				) {
		if(result.hasErrors()) {
			 model.addAttribute("expends", eService.getall());
			 return "dashboard.jsp";
		}
		
		eService.createorupdate(expend);
		
		return "redirect:/expends";
	}
	
	@GetMapping("/expend/detail/{id}")
	public String rExpendDetails(@PathVariable("id") Long expendId, Model model) {
		model.addAttribute("expend", eService.getOne(expendId));
		return "expendDetail.jsp";
	}
	
	
	
		
	@GetMapping("/expend/edit/{id}")
	public String reditExpend(@PathVariable("id") Long expendId, Model model) {
		model.addAttribute("expend", eService.getOne(expendId));
		return "expend.jsp";
	}
	
	@PutMapping("/expend/edit/{id}")
	public String peditExpend(
			@PathVariable("id") Long expendId,
			@Valid @ModelAttribute("expend") Expend expend,
			BindingResult result,		
			Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("expend", eService.getOne(expendId));
			return "expend.jsp";
		}
		eService.createorupdate(expend);
		return String.format("redirect:/expend/edit/%s", expendId);
		
	}
	
	@DeleteMapping("/expend/delete/{id}")
	public String detroy(@PathVariable("id") Long expendId) {
		eService.deleteExpend(expendId);
		return "redirect:/expends";
	}
	
}

