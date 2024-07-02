package com.example.userapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userapi.payloads.ApiResponse;
import com.example.userapi.payloads.UserDto;
import com.example.userapi.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	//POST - create user
	@PostMapping(value="/",consumes={"application/json"})
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createdUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<UserDto>(createdUserDto,HttpStatus.CREATED) ;
	}
	//GET - get all users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> userDtos = this.userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(userDtos,HttpStatus.OK) ;
	}
	//GET - get user by id
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("userId") int id){
		UserDto userDto = this.userService.getUserById(id);
		return ResponseEntity.ok(userDto) ;
	}
	//PUT- update user
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable int id){
		UserDto createdUserDto = this.userService.updateUser(userDto, id);
		return ResponseEntity.ok(createdUserDto) ;
	}
	//DELETE - delete user
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable int id){
		this.userService.deleteUser(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK) ;
	}
}
