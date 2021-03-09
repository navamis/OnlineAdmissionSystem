package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.entities.Login;


public interface ILoginRepository  extends JpaRepository<Login, Integer>  {

	Login findByUserId(int userId);

//	Login getLoginDetailsById(int userId);

//	Login deleteLoginDetailsById(int userId);

	//Login changePassword(Login login);
	
	//Login resetPassword(Login login);

	

}
