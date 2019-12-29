package com.hari;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String TEMPLATE = "Hello, %s!";

	@RequestMapping("/greeting")
	public HttpEntity<Greeting1> greeting() {
		final String name = "hari";
		final Greeting1 greeting1 = new Greeting1(String.format(TEMPLATE, name));
		greeting1.add(getAllLinks());
		return new ResponseEntity<>(greeting1, HttpStatus.OK);
	}

	@RequestMapping("/greeting2")
	public EntityModel<Greeting> greeting2() {
		final String name = "hari";
		final Greeting greeting = new Greeting(String.format(TEMPLATE, name));
		final EntityModel<Greeting> entityModel = new EntityModel<>(greeting, getAllLinks());
		return entityModel;
	}

	@RequestMapping("/greeting3")
	public CollectionModel<Greeting> greeting3() {
		final String name = "hari";
		final Collection<Greeting> greeting = Collections.singleton(new Greeting(String.format(TEMPLATE, name)));
		final CollectionModel<Greeting> entityModel = new CollectionModel<>(greeting);
		entityModel.add(getAllLinks());
		return entityModel;
	}

	public List<Link> getAllLinks() {
		return Arrays.asList(linkTo(methodOn(this.getClass()).greeting()).withSelfRel(),
				linkTo(methodOn(this.getClass()).greeting2()).withRel("Greeting2"),
				linkTo(methodOn(this.getClass()).greeting3()).withRel("Greeting3"));

	}
}
