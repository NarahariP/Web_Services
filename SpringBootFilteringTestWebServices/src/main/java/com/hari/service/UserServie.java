package com.hari.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.hari.model.User;
import com.hari.model.User2;

public class UserServie {

	private static List<User> userList = new ArrayList<>();
	private static List<User2> userList2 = new ArrayList<>();

	static {
		final User user1 = new User(1, "username1", "2", new Date());
		final User user2 = new User(2, "username2", "5", new Date());
		final User user3 = new User(3, "username3", "7", new Date());
		final User user4 = new User(4, "username4", "8", new Date());
		final User user5 = new User(5, "username5", "9", new Date());
		userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));

		final User2 user11 = new User2(11, "username11", "32", new Date());
		final User2 user22 = new User2(12, "username12", "45", new Date());
		final User2 user33 = new User2(13, "username13", "27", new Date());
		final User2 user44 = new User2(14, "username14", "18", new Date());
		final User2 user55 = new User2(15, "username15", "91", new Date());
		userList2.addAll(Arrays.asList(user11, user22, user33, user44, user55));
	}

	public static List<User> getAllUsers() {
		return userList;
	}

	public static List<User2> getAllUsers2() {
		return userList2;
	}
}
