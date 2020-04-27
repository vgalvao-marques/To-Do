package com.servlet.model;

import java.util.Optional;

import com.servlet.utils.fakedb.UserDB;

public class User {

	private int id;
	private String name;
	private String email;
	private String password;

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static boolean validateCredential(String email, String password) {

		UserDB udb = new UserDB();
		Optional<User> uo = udb.get(email);

		if (uo.isPresent()) {
			if (uo.get().getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}
}
