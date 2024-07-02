package com.example.userapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userapi.entities.User;
import com.example.userapi.payloads.UserDto;
import com.example.userapi.repositories.UserRepo;
import com.example.userapi.services.UserService;
import com.example.userapi.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		User createdUser = this.userRepo.save(user);
		return this.modelMapper.map(createdUser, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map((user)->this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public UserDto getUserById(int id) {
		User user = this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

	@Override
	public UserDto updateUser(UserDto userDto, int id) {
		User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser = this.userRepo.save(user);
		return this.modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public void deleteUser(int id) {
		User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
		this.userRepo.delete(user);
	}

}
