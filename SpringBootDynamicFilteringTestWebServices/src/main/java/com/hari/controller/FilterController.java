package com.hari.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Function;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.hari.service.UserServie;

@RestController
public class FilterController {

	Function<Object, MappingJacksonValue> userFunction = user -> {
		final MappingJacksonValue jacksonValue = new MappingJacksonValue(user);
		jacksonValue.setFilters(new SimpleFilterProvider().addFilter("UserFilter",
				new SimpleBeanPropertyFilter.FilterExceptFilter(new HashSet<>(Arrays.asList("deptNo", "userName")))));
		return jacksonValue;
	};

	@RequestMapping("/user")
	public MappingJacksonValue getUser() {
		return userFunction.apply(UserServie.getUser());
	}

	@RequestMapping("/filter-info")
	public MappingJacksonValue getUserInfo() {
		return userFunction.apply(UserServie.getAllUsers());
	}

}
