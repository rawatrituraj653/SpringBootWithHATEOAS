package com.nit.hateoas.pojo;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.hateoas.ResourceSupport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Author extends ResourceSupport{
	private String  authorName;
	private String authorEmail;
	private String authorCityName;
	private String authorCountryName;	
}
