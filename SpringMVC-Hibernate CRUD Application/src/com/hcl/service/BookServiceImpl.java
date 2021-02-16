package com.hcl.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.BookDao;
import com.hcl.model.Book;


@Service
public class BookServiceImpl implements BookService {
	
	private BookDao bookDao;
	
	
	
	@Autowired(required=true)
	public void setBookDao(BookDao bookDao) {
		this.bookDao=bookDao;
		
	}
	
	@Transactional
	public void addBook(Book book) {
		bookDao.addBook(book);
		
	}
	
	@Transactional
	public void removeBook(Integer id) {
		bookDao.removeBook(id);
	}
	
	@Transactional
	public List<Book> listBooks() {
		return bookDao.listBooks();
	}
	
	@Transactional
	public void updateBook(Book book) {
		bookDao.updateBook(book);
		
	}
	
	@Transactional
	public Book getBookById(Integer bookId) {
		return bookDao.getBookById(bookId);
	}
	
}

	