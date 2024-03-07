package com.tekbasic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tekbasic.entity.User;
import com.tekbasic.model.UpdatePasswordModel;
@Service
public interface UserService {

	public List<User> getAllUser();
	public User addUser(User user);
	public Optional<User> getUserById(int id);
	public void editUser(User user,int id);
	public void deleteUser(int id);
	public Optional<User> getLoginUSer(String userName);
}
