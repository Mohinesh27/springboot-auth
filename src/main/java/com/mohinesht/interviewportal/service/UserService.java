package com.mohinesht.interviewportal.service;

import com.mohinesht.interviewportal.models.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}