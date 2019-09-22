package com.nit.hateoas.rest;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.hateoas.pojo.Author;
import com.nit.hateoas.pojo.Book;

@RestController
@RequestMapping("/book")
public class BookRestController {

	@GetMapping("/getBook/{isbn}")
	public ResponseEntity<Book> getBook(@PathVariable  String isbn){
		Book b=new Book();
		b.setBookId(isbn);
		b.setBookName("Spring");
		b.setBookPrice(500.00);
		Link selfLink=ControllerLinkBuilder.linkTo(ControllerLinkBuilder
				.methodOn(BookRestController.class).getBook(isbn))
				//.slash(b.getBookId())
				.withSelfRel();
		b.add(selfLink);
		
		Link authorLink=ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(BookRestController.class)
				.getAuthor(isbn))
				.withRel("author");
		b.add(authorLink);
		return new ResponseEntity<Book>(b,HttpStatus.OK);
	}
	
	@GetMapping("/author/{id}")
	public ResponseEntity<Author> getAuthor(@PathVariable String id){
		Author author=new Author();
		author.setAuthorName("Rituraj");
		author.setAuthorEmail("Rrituraj047@gmail.com");
		author.setAuthorCityName("Los Angles");
		author.setAuthorCountryName("U.S.A");
		return new ResponseEntity<Author>(author,HttpStatus.OK);
	}
}
