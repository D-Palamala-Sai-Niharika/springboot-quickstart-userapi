package com.example.userapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //AUTOINCREMENT
	private int id;
	
	@Column(name="user_name",nullable=false,length=100)
	private String name;
	
	@Column
	private String email;
	
	private String password;
	
	private String about;
}

