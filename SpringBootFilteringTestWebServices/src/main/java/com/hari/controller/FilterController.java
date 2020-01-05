package com.hari.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.model.User;
import com.hari.model.User2;
import com.hari.service.UserServie;

@RestController
public class FilterController {

	@RequestMapping("/filter-info")
	public List<User> getUserInfo() {
		return UserServie.getAllUsers();
	}

	@RequestMapping("/filter-info2")
	public List<User2> getUserInfo2() {
		return UserServie.getAllUsers2();
	}
}
