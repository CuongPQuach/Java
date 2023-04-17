package com.userdata.userloginreg.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.userdata.userloginreg.models.LoginUser;
import com.userdata.userloginreg.models.User;
import com.userdata.userloginreg.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo uRepo;
								// data get from Controller
	public User register(User newUser, BindingResult result) {
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
//		Bcrypt password and send to back end 
			String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashedPassword); //set password will save to the DB
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
