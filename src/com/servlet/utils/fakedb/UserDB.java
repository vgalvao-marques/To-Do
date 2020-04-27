package com.servlet.utils.fakedb;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import com.servlet.model.User;

public class UserDB {

	private static int seq_id = 100;
	private static Map<Integer, User> users = new LinkedHashMap<Integer, User>();

	static {
		User root = new User("Root", "root@root.com", "r1r2r3");
		root.setId(0);
		users.put(root.getId(), root);
	}

	public void add(User user) {
		user.setId(seq_id++);
		UserDB.users.put(user.getId(), user);
	}

	public Optional<User> get(String email) {
		ArrayList<User> users = new ArrayList<User>(UserDB.users.values());
		Optional<User> findFirst = users.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst();
		return findFirst;
	}

}
