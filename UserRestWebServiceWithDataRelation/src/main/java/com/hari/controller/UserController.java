package com.hari.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hari.exception.AddressNotFoundException;
import com.hari.exception.UserNotFoundException;
import com.hari.model.Address;
import com.hari.model.User;
import com.hari.repository.AddressRepository;
import com.hari.repository.UserRepositoty;

@RestController
public class UserController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserRepositoty userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Id -" + id));
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

	@GetMapping("/welcome")
	public String welcomeMessage() {
		return messageSource.getMessage("welcome.message", null, LocaleContextHolder.getLocale());
	}

	@GetMapping("/users/{id}/address")
	public List<Address> getUserAddress(@PathVariable int id) {
		return userRepository.findById(id).map(user -> {
			return user.getAddress();
		}).orElseThrow(() -> new UserNotFoundException("User Id -" + id));
	}

	@PostMapping("/users/{id}/address")
	public ResponseEntity<Address> getUserAddress(@PathVariable int id, @RequestBody Address address) {
		address.setUser(getUserById(id));
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}")
				.buildAndExpand(addressRepository.save(address).getId()).toUri()).build();
	}

	@PutMapping("/users/{id}/address")
	public ResponseEntity<Address> updateUserAddress(@PathVariable int id, @RequestBody Address address) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}")
				.buildAndExpand(addressRepository.save(address.addUser(getUserById(id), address)).getId()).toUri())
				.build();
	}

	@GetMapping("/users/{id}/address/{addressId}")
	public Address getUserAddress(@PathVariable int id, @PathVariable int addressId) {
		getUserById(id);
		return addressRepository.findById(addressId)
				.orElseThrow(() -> new AddressNotFoundException("Address Id -" + id));
	}

	@DeleteMapping("/users/{id}/address/{addressId}")
	public void deleteAddress(@PathVariable int id, @PathVariable int addressId) {
		getUserById(id);
		addressRepository.deleteById(addressId);
	}

}
