package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.serviceimpl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.entities.Login;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.entities.User;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.exceptions.LoginException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.exceptions.UserNotFoundException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.repo.ILoginRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.repo.IUserRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.services.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserRepository userRepository;

	@Autowired
	ILoginRepository loginRepository;

	@Override
	public User addUserDetails(User user) {
		userRepository.save(user);
		return user;
		}

	@Override
	public Login addLoginDetails(Login login) {
		loginRepository.save(login);
		return login;
		}

	@Override
	public ArrayList<User> getAllUserDetails() {
		ArrayList<User> user1 = new ArrayList<User>(userRepository.findAll());
		System.out.println(user1);
		return user1;
		}

	@Override
	public ArrayList<Login> getAllLoginDetails() {
		ArrayList<Login> login1 = new ArrayList<Login>(loginRepository.findAll());
		System.out.println(login1);
		return login1;
		}

	@Override
	public User getUserDetailsById(int userId) {		
		 User user1 = userRepository.findByUserId(userId);
		 System.out.println(user1);
		 return user1;
	}

	@Override
	public Login getLoginDetailsById(int userId) {
		Login login2 = loginRepository.findByUserId(userId);
		System.out.println(login2);
		return login2;
		}


	@Override
	public User deleteUserDetailsById(int userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isEmpty()){
			throw new UserNotFoundException("User not found with id : "+userId);
		}
		User u = user.get();
		userRepository.delete(u);
		return u;
	}
//	Optional<User> user = userRepository.findById(userId);
//	if(user.isEmpty()){
//		throw new UserNotFoundException("User not found with id : "+userId);
//	}
//	User u = user.get();
//	userRepository.delete(u);
//	return u;
//	}
	
//	@Override
//	public Login deleteLoginDetailsById(int userId) {
//		Optional<Login> login = loginRepository.findById(userId);
//		if(login.isEmpty()){
//			throw new LoginException("User not found with id : "+ userId);
//		}
//		Login l = login.get();
//	    loginRepository.delete(l);
//		return l;
//		}
//	

	

	@Override
	public Login deleteLoginDetailsById(int userId)  {
		Optional<Login> del1 = loginRepository.findById(userId);
		Login l = del1.get();
		loginRepository.delete(l);
		System.out.println(l);
		return l;
	}
		

		@Override
		public Login changePassword(Login login) {
			Optional<Login> login3 = loginRepository.findById(login.getUserId());
			if(login3.isPresent())
			{
				Login changePassword = login3.get();
				changePassword.setPassword(login.getPassword());
		}
			return login;
		}

	

		@Override
		public Login resetPassword(Login login) {
			Optional<Login> login3 = loginRepository.findById(login.getUserId());
			if(login3.isPresent()) {
				Login cp = login3.get();
				cp.getPassword();
				loginRepository.delete(cp);
			}
				if(login3.isEmpty()) {
				Login resetPassword = login3.get();
				resetPassword.setPassword(login.getPassword());
			}
			return login;	
			
		}
		
	
	@Override
	public User updateUserDetails(User user) {
		Optional<User> user3 = userRepository.findById(user.getUserId());
		if(user3.isPresent())
		{
			User adduser = user3.get();
			adduser.setEmail(user.getEmail());
			adduser.setFirstName(user.getFirstName());
			adduser.setMiddleName(user.getMiddleName());
			adduser.setLastName(user.getLastName());
			adduser.setMobileNumber(user.getMobileNumber());
			adduser.setAadharCardNo(user.getAadharCardNo());
		}
		System.out.println(user3);
		return user;		
		
	}


	

	



	
	
}
