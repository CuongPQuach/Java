package com.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.bookclub.models.LoginUser;
import com.bookclub.models.User;
import com.bookclub.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo uRepo;
	
	public User register(User newUser,BindingResult result) {
//		Check Confirm Password 
		if (!newUser.getConfirm().equals(newUser.getPassword())) {
			result.rejectValue("confirm","Matches","Miss Match Confirm Pasword");
		}
//		Check Email in Data Base
		Optional<User> userindata = uRepo.findByEmail(newUser.getEmail());
		if(userindata.isPresent()) {
			result.rejectValue("email","Matches","Email is already register.");
		}
//		Checking Form Fields
		if(result.hasErrors()) {
			return null;
		} else {
//			Bcrypt password and send to back end 
			String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashedPassword);
			return uRepo.save(newUser);
		}
	}	
	
//	login User
	public User login(
			LoginUser newLogin,
			BindingResult result
			) {
		Optional<User> optionalUser = uRepo.findByEmail(newLogin.getEmail());
		if(!optionalUser.isPresent()) {
			result.rejectValue("email","Matches","Login Invalid Email.");
			result.rejectValue("password","Matches","Login Invalid Password.");
			return null;
		}
		User thisUser = optionalUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(),thisUser.getPassword())) {
			result.rejectValue("email","Matches","Login Invalid Email.");
			result.rejectValue("password","Matches","Login Invalid Password.");
			return null;
		}
		return thisUser;
	}
	
//	Find By ID
	public User findById(Long id) {
		Optional<User> optionalUser = uRepo.findById(id);
		return optionalUser.orElseGet(() -> null);
	}
	
//	Find By Email
	public User findByEmail(String email) {
		Optional<User> optionalUser = uRepo.findByEmail(email);
		return optionalUser.orElseGet(() -> null);
	}
	
//	update User
	public User updateUser(User newUser) {
		return uRepo.save(newUser);
	}
	
//	delete User
	public void deleteUser(Long id) {
		uRepo.deleteById(id);
	}
	
	
}
