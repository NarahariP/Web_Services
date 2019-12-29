package com.hari.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hari.exception.UserNotFoundException;
import com.hari.model.User;
import com.hari.repository.UserRepositoty;

@RestController
public class UserController {

	@Autowired
	private UserRepositoty userRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> getUserById(@PathVariable int id) {

		/**
		 * userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Id -" + id));
		 *
		 * return new
		 * EntityModel<>(userRepository.findById(id).get()).add(linkTo(methodOn(this.getClass()).getAllUsers()).withRel("all-users"));
		 */
		return userRepository.findById(id).map(user -> {
			return new EntityModel<>(user).add(linkTo(methodOn(this.getClass()).getAllUsers()).withRel("all-users"));
		}).orElseThrow(() -> new UserNotFoundException("Id - " + id));

	}

	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(userRepository.save(user).getId()).toUri()).build();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		userRepository.deleteById(id);
	}
}
