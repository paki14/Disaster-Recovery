package com.tekbasic.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tekbasic.entity.Role;
import com.tekbasic.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseModel {

	private int id;
	private String name;
	private String address;
	private String username;
	private String email;
	private String password;
	private Role role;
}
