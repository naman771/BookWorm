package com.comrade.booksapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comrade.booksapi.entity.Author;
import com.comrade.booksapi.service.AuthorService;

@RestController
@RequestMapping("/api")
public class AuthorRestController {

	@Autowired
	private AuthorService authorService;
	
	
	@GetMapping("/authors")
	public List<Author> findAll(){
		return authorService.findAll();
	}
	@GetMapping("/author/{name}")
	public Author findAuthor(@PathVariable String name) {
		Author author=authorService.findBookByName(name);
		if(author==null) {
			throw new RuntimeException("Author not found with name"+ name);
		}
		return author;
	}
	
	@PostMapping("/authors")
	public Author save(@RequestBody Author author) {
		authorService.save(author);
		return author;
	}
	@PutMapping("/authors")
	public Author updateAuthor(@RequestBody Author author) {
		authorService.save(author);
		return author;
	}
	
	@DeleteMapping("/authors/{name}")
	public String deleteAuthor(@PathVariable String name) {
		Author author=authorService.findBookByName(name);
		if(author==null) {
			throw new RuntimeException("Author not found with name"+name);
		}
		authorService.delete(name);
		return "author"+name+"deleted from database";
	}
}
