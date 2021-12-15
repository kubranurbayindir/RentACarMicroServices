package com.appsdeveloperblog.rentacar.users.business.abstracts;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.appsdeveloperblog.rentacar.users.business.dtos.UserDtos.UserDto;
import com.appsdeveloperblog.rentacar.users.business.requests.UserRequests.LoginUserRequest;
import com.appsdeveloperblog.rentacar.users.core.utils.results.Result;

public interface UserService extends UserDetailsService {
	
	Result login(LoginUserRequest loginUserRequest);
	Result isUserExists(int userId);
	Result isUserEmailExists(String email);
	
	UserDto getUserDetailsByEmail(String email);

}
