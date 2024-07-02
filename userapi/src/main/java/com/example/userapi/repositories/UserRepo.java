package com.example.userapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userapi.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
