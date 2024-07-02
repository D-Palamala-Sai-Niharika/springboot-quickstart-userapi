package com.example.userapi.services;

import java.util.List;

import com.example.userapi.payloads.UserDto;

public interface UserService {
	//methods in an interface are implicitly public
	//create user
	UserDto createUser(UserDto userDto);
	//get all users
	List<UserDto> getAllUsers();
	//get user by id
	UserDto getUserById(int id);
	//update user
	UserDto updateUser(UserDto userDto,int id);
	//delete user
	void deleteUser(int id);
}
