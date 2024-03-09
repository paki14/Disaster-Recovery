package com.tekbasic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tekbasic.config.AuthenticationService;
import com.tekbasic.entity.User;
import com.tekbasic.model.AuthenticationResponse;
import com.tekbasic.model.LoginModel;
import com.tekbasic.repo.UpdatePasswordModel;
import com.tekbasic.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http//:localhost:4210")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationService authenticationService;
	@PostMapping("/addUser")
	@ResponseStatus(HttpStatus.CREATED)
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AuthenticationResponse> loginCredientials(@RequestBody LoginModel login){
		return ResponseEntity.ok( authenticationService.authenticate(login));
	}
//	public Optional<User> getLogin(@RequestBody LoginModel login){
//		System.out.println(login.getUsername());
//		return userService.getLoginUSer(login.getUsername());
//	}
	@PutMapping("/updatePassword")
	public String updatePassWord(@RequestBody UpdatePasswordModel updatePasswordModel) {
		int x=userService.updatePassword(updatePasswordModel);
		if(x!=0) {
			return "password updated ";
		}else return "Username or Email mismatch";
		
	}
	@PutMapping("/editUser/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void editUser(@RequestBody User user,@PathVariable("id")int id) {
		userService.editUser(user, id);
	}
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable("id")int id) {
		userService.deleteUser(id);
	}
	@GetMapping("/viewAll")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
}
