package com.bookclub.controllers;

import javax.servlet.http.HttpSession;
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

import com.bookclub.models.Book;
import com.bookclub.models.LoginUser;
import com.bookclub.models.User;
import com.bookclub.services.BookService;
import com.bookclub.services.UserService;



@Controller
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private HttpSession session;
	@Autowired
	private BookService bService;
	
	@GetMapping("/")
	public String loginRegPage(
			@ModelAttribute("registerUser") User newUser,
			@ModelAttribute("loginUser") LoginUser loginUser
			) {
		return "loginreg.jsp";
	}	
	
//	Register user if valid
	@PostMapping("/register")
	public String registerUser(
			@Valid 
			                   // where data get from JSP
			@ModelAttribute("registerUser" ) User newUser,
			BindingResult result,
			@ModelAttribute ("loginUser") LoginUser loginUser		
			) {
//		User in the form
		User changedUser = uService.register(newUser, result); //call for addtional valid
		
		if (result.hasErrors()) {
			return "loginreg.jsp";
		}
//		user is registed in the data
		session.setAttribute("userId", changedUser.getId());
//		go to dashboard
		return "redirect:/allBooks";
	}
	
//	User Login
	@PostMapping ("/login")
	public String loginUser(
			@Valid @ModelAttribute("loginUser") LoginUser loginUser,
			BindingResult result,
			@ModelAttribute("registerUser" ) User newUser
			) {
		User foundUser = uService.login(loginUser, result);
		if (result.hasErrors()) {
			return "loginreg.jsp";	
		}
		session.setAttribute("userId", foundUser.getId());
		return "redirect:/allBooks";
	}
	@GetMapping ("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/allBooks")
	public String allBooks(
			Model viewModel
			) {
			if (session.getAttribute("userId") == null) {
				return "redirect:/"; 
			}
			Long userId = (Long) session.getAttribute("userId");
			viewModel.addAttribute("loggedUser", uService.findById(userId));
			viewModel.addAttribute("allBooks", bService.findAllBook());
			return "allBooks.jsp";
	}
//	Books View 
	@GetMapping("/books/new")
	public String newBookClubPage(
			Model viewModel,
			@ModelAttribute("newBook") Book newBook
			) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User loggedUser = uService.findById((Long) session.getAttribute("userId"));
		viewModel.addAttribute("loggedUser", loggedUser);
		return "addBook.jsp";
	}
	
//	Books Posting
	@PostMapping("/books/new")
	public String addBookToDB(
			@Valid @ModelAttribute("newBook") Book newBook,
			BindingResult result
			) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "addBook.jsp";
		}
		bService.createBook(newBook);
		return "redirect:/allBooks"; 
	}
	
//	Eddit Books 
//	view
	@GetMapping("/books/{id}/edit")
	public String editBooksPage(
			@PathVariable("id") Long id,
			Model viewModel
			) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Book thisBook = bService.findBookById(id);
		User loggedUser = uService.findById((Long) session.getAttribute("userId"));
		viewModel.addAttribute("loggedUser", loggedUser);
		if (!loggedUser.getId().equals(thisBook.getCreator().getId())) {
			return "redirect:/allBooks";
		}
		viewModel.addAttribute("editBook", thisBook);
		viewModel.addAttribute("loggedUser", loggedUser);
		return "editBook.jsp";
	}
//	Put Edit to db
	@PutMapping("/books/{id}/edit")
	public String editBooksDB(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("editBook") Book editBook, 
			BindingResult result,
			Model viewModel
			) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User loggedUser = uService.findById((Long) session.getAttribute("userId"));
		if (!loggedUser.getId().equals(editBook.getCreator().getId())) {
			return "redirect:/allBooks";
		}
		if (result.hasErrors()) {
			viewModel.addAttribute("loggedUser", loggedUser);
			return "editBook.jsp";
		}
		bService.updateBook(editBook);
		return "redirect:/allBooks";
	}
	
//	My book mapping
	@GetMapping("/myBooks")
	public String myBooksPage() {
		if (session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
		return "myBooks.jsp";
	}
	
	@GetMapping("/Book/{id}")
	public String viewBooksPage(
			@PathVariable("id") Long id,
			Model viewModel
			) {
		if (session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
		viewModel.addAttribute("thisBook", bService.findBookById(id));
		User loggedUser = uService.findById((Long) session.getAttribute("userId"));
		viewModel.addAttribute("loggedUser", loggedUser);
		return "viewBook.jsp";
	}
	
	@DeleteMapping("/Books/{id}/delete")
	public String delteBookFromDB(
			@PathVariable("id") Long id
			) {
		if (session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
		User loggedUser = uService.findById((Long) session.getAttribute("userId"));
		Book thisBook = bService.findBookById(id);
		if (!loggedUser.getId().equals(thisBook.getCreator().getId())) {
			return "redirect:/allBooks";
		}
		bService.deleteBookId(thisBook.getId());
		return "redirect:/allBooks";
	}	
}
