package com.hcl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="BOOKS")
public class Book {
	
	@Id
	@Column(name="BOOK_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="BOOK_NAME")
	@NotEmpty
	private String bookName;
	
	
	@Column(name="AUTHOR")
	@NotEmpty(message="Author name should not be blank.")
	@Size(min=3,max=10)
	private String author;
	
	
	@Column(name="PRICE")
	@NotNull(message="Price should not be blank.")
	private Integer price;
	
	
	@Column(name="QUANTITY")
	@NotNull(message="Qunatity should not be blank.")
	private Integer quantity;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	
	

}
