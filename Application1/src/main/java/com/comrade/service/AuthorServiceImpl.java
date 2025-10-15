package com.comrade.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.comrade.model.Author;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private RestTemplate restTemplate;

	private static final String GET_ALL_AUTHORS_API = "http://localhost:8081/api/authors";

	public List<Author> findAll() {
		Author[] authorList = restTemplate.getForObject(GET_ALL_AUTHORS_API, Author[].class);
		return Arrays.asList(authorList);
	}
}
