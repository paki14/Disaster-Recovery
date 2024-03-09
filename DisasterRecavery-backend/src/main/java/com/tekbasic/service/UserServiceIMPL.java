package com.tekbasic.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tekbasic.entity.User;
import com.tekbasic.repo.UserRepository;
@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User addUser(User user) {
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public void editUser(User user, int id) {
		userRepository.updateUser(user.getName(), user.getEmail(), user.getAddress(), id);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public Optional<User> getLoginUSer(String userName) {
		return userRepository.findByUsername(userName);
	}

	

}
