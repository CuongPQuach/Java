package com.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.models.Book;
import com.bookclub.repositories.BookRepo;

@Service
public class BookService {
	@Autowired
	private BookRepo bRepo;
	
	
// create Book
	public Book createBook(Book newBook) {
		  return bRepo.save(newBook);
	}
	
//	find all Book
	public List<Book> findAllBook(){
		return bRepo.findAll();
	}
//	find One Book 
	public Book findBookById(Long id) { 
		Optional<Book> optionalBook = bRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	
	
	
//	update Book
	public Book updateBook(Book updateBook) {
		return bRepo.save(updateBook);
	}
// delete Book
	public void deleteBookId(Long id) {
		bRepo.deleteById(id);
	}
	
	
}
