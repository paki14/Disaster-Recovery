package com.tekbasic.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tekbasic.entity.User;
import com.tekbasic.model.UserResponseModel;
import com.tekbasic.repo.UpdatePasswordModel;
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

	@Override
	public int updatePassword(UpdatePasswordModel updatePasswordModel) throws UsernameNotFoundException {
		int x=0;
		Optional<User> optUser=userRepository.findBYEmailandUsername(updatePasswordModel.getEmail(),
				updatePasswordModel.getUsername());
		if(optUser.isPresent()) {
			User user=optUser.get();
			user.setPassword(this.bCryptPasswordEncoder.encode(updatePasswordModel.getPassword()));
		 x =userRepository.updatePassword(updatePasswordModel.getEmail(),updatePasswordModel.getUsername(),user.getPassword());
		}else throw new UsernameNotFoundException("Email and Username not matched");
			
		return x;
	}

	

}
