package com.rise.interviewportal.service;

import com.rise.interviewportal.models.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}