package com.hari.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.model.Name;
import com.hari.model.UserVersion1;
import com.hari.model.UserVersion2;

@RestController
public class VersionController {

	Name name = new Name("Firstname", "LastName");
	UserVersion1 userVersion1 = new UserVersion1(1, "Firstname Lastname", new Date());
	UserVersion2 userVersion2 = new UserVersion2(1, name, new Date());

	/** *****URI Version >>> */
	@GetMapping("/v1/user")
	public UserVersion1 userURIVersion1() {
		return userVersion1;
	}

	@GetMapping("/v2/user")
	public UserVersion2 userURIVersion2() {
		return userVersion2;
	}

	/** *****Param Version >>> */
	@GetMapping(value = "/user/param", params = "version=1")
	public UserVersion1 userParamVersion1() {
		return userVersion1;
	}

	@GetMapping(value = "/user/param", params = "version=2")
	public UserVersion2 userParamVersion2() {
		return userVersion2;
	}

	/** *****Header Version >>> */
	@GetMapping(value = "/user/header", headers = "X-API-VERSION=1")
	public UserVersion1 userHeaderVersion1() {
		return userVersion1;
	}

	@GetMapping(value = "/user/header", headers = "X-API-VERSION=2")
	public UserVersion2 userHeaderVersion2() {
		return userVersion2;
	}

	/** *****MIME Type/Produces Version >>> */
	@GetMapping(value = "/user/produces", produces = "application/hari.company.app-v1+json")
	public UserVersion1 userProducesVersion1() {
		return userVersion1;
	}

	@GetMapping(value = "/user/produces", produces = "application/hari.company.app-v2+json")
	public UserVersion2 userProducesVersion2() {
		return userVersion2;
	}
}
