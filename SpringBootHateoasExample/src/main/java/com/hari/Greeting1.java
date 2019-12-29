package com.hari;

import org.springframework.hateoas.RepresentationModel;

public class Greeting1 extends RepresentationModel<Greeting1> {

	private final String content;

	public Greeting1(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
