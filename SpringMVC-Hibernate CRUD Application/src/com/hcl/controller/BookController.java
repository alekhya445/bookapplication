package com.hcl.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.Book;
import com.hcl.service.BookService;

@Controller
public class BookController {
	
	private BookService bookService;
	
	
	@Autowired(required=true)
	public void setBookService(BookService bookService) {
		this.bookService=bookService;
	}
	
	
	@RequestMapping("/index")
	public ModelAndView listBooks() {
		ModelAndView model=new ModelAndView();
		
		
		model.addObject("book",new Book());
		model.addObject("bookList",bookService.listBooks());
		model.setViewName("book");
		return model;
		
	}
	
//code for entering the data in the form-book.getId() is null.adds new book otherwise updates,exsisting  book details//
	@RequestMapping(value="/book/add",method = RequestMethod.POST)
	public String addBook(@Valid @ModelAttribute("book")Book book,BindingResult result,Map<String,Object>map) {
		  
		
		
		if(result.hasErrors()) {
			map.put("bbokList",bookService.listBooks());
			return "book";
		} else {
			if(book.getId()==null) {
				bookService.addBook(book);
			} else {
				bookService.updateBook(book);
			}
			
			return "redirect:/index";
		}
	}
	
	
	@RequestMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") Integer bookId) {
		bookService.removeBook(bookId);
		return "redirect:/index";
		
	}
	
	@RequestMapping("/edit/{bookId}")
	public String deleteBook(@PathVariable("bookId") Integer bookId,Map<String,Object>map) {
		map.put("book",bookService.getBookById(bookId));
		map.put("bookList",bookService.listBooks());
		return "book";
	}
}
	
	


			