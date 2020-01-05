package com.hari.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.hari.model.User;

public class UserServie {

	private static List<User> userList = new ArrayList<>();

	static {
		final User user1 = new User(1, "username1", "2", new Date());
		final User user2 = new User(2, "username2", "5", new Date());
		final User user3 = new User(3, "username3", "7", new Date());
		final User user4 = new User(4, "username4", "8", new Date());
		final User user5 = new User(5, "username5", "9", new Date());
		userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
	}

	public static User getUser() {
		return new User(100, "username", "85", new Date());
	}

	public static List<User> getAllUsers() {
		return userList;
	}

}
