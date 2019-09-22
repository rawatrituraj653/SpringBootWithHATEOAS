package com.nit.hateoas.pojo;


import org.springframework.hateoas.ResourceSupport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book extends ResourceSupport{
	private String bookId;
	private String bookName;
	private Double bookPrice;
}
