package com.appsdeveloperblog.rentacar.users.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appsdeveloperblog.rentacar.users.entities.User;

public interface UsersDao extends JpaRepository<User,Integer> {
	
	User getByEmail(String email);
	
	boolean existsUserByEmail(String email);

}
