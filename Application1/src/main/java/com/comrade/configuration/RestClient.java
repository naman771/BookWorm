package com.comrade.configuration;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	private static final String GET_ALL_BOOKS_API = "http://localhost:8081/api/books";
	private static final String GET_BOOK_BY_CODE_API = "http://localhost:8081/api/books/{code}";
	private static final String CREATE_BOOK_API = "http://localhost:8081/api/books";
	private static final String UPDATE_BOOK_API = "http://localhost:8081/api/books";
	private static final String DELETE_BOOK_API = "http://localhost:8081/api/books/{code}";

	static RestTemplate restTemplate=new RestTemplate();
	
	public static void callGetAllBooksApi() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_BOOKS_API, HttpMethod.GET, entity, String.class);
	}
}
