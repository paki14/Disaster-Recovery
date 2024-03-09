package com.tekbasic.repo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UpdatePasswordModel {
	
	private String username;
	private String email;
	private String password;
}
