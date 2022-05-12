package com.kritika.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kritika.demo.Repoistory.BookRepoistory;
import com.kritika.demo.model.Book;

@RestController
public class BookController 
{
	@Autowired
	private BookRepoistory bookRepoistory;
	@PostMapping("/addBook")
	public String addBook(@RequestBody Book book)
	{
		bookRepoistory.save(book);
		return "Book Sucessfully added";
	}
	@GetMapping("/findAllBooks")
	public List<Book> findAllBooks()
	{
		return bookRepoistory.findAll();
	}
	@GetMapping("/findBook/{id}")
	public Book findBook(@PathVariable Integer id)
	{
		Book book = new Book();
		Optional<Book> o = bookRepoistory.findById(id);
		if(!o.isEmpty())
		{
			book = o.get();
		}
		return book;
	}
	@DeleteMapping("/deleteBook")
	public String deleteBook(@RequestParam Integer id)
	{
		String msg = "Book Not Found";
		Book book = findBook(id);
		if(book.getId()!=null)
		{
			bookRepoistory.delete(book);
			msg = "Book Deleted";
		}
		return msg;
	}
	@PutMapping("/updateBook")
	public Book updatebook(@RequestBody Book book)
	{
		Book myBook = findBook(book.getId());
		if(myBook.getId()==null)
		{
			return myBook;
		}
		return bookRepoistory.save(book);
	}
}
