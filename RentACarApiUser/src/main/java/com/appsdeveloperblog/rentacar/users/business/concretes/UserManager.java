package com.appsdeveloperblog.rentacar.users.business.concretes;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.rentacar.users.business.abstracts.UserService;
import com.appsdeveloperblog.rentacar.users.business.dtos.UserDtos.UserDto;
import com.appsdeveloperblog.rentacar.users.business.requests.UserRequests.LoginUserRequest;
import com.appsdeveloperblog.rentacar.users.core.utils.mapping.ModelMapperService;
import com.appsdeveloperblog.rentacar.users.core.utils.results.ErrorResult;
import com.appsdeveloperblog.rentacar.users.core.utils.results.Result;
import com.appsdeveloperblog.rentacar.users.core.utils.results.SuccessResult;
import com.appsdeveloperblog.rentacar.users.dataAccess.UsersDao;
import com.appsdeveloperblog.rentacar.users.entities.User;

@Service
public class UserManager implements UserService {
	
	private UsersDao usersDao;

	@Autowired
	public UserManager(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public Result login(LoginUserRequest loginUserRequest) {
	
		var result = checkCredentials(loginUserRequest.getEmail(),loginUserRequest.getPassword());
		if (!result.isSuccess()) {
			return result;
		}
		return new SuccessResult("Giriş işlemi yapıldı.");
		
	}
	
	private Result checkCredentials(String email,String password) {
		var result = this.usersDao.existsUserByEmail(email);
		if (!result) {
			return new ErrorResult("Mail adresi sistemde kayıtlı değil");
		}
		
		var user =  this.usersDao.getByEmail(email);
		if (user == null) {
			return new ErrorResult("Mail adresi sistemde kayıtlı değil");
		}
		
		if (!(user.getPassword().equals(password))) {
			return new ErrorResult("Giriş bilgileriniz yanlış");
		}
		return new SuccessResult();	
	}


	@Override
	public Result isUserExists(int userId) {
		var isExists = this.usersDao.existsById(userId);
		if (!isExists) {
			return new ErrorResult("Kullanıcı bulunamadı.");
		}
		return new SuccessResult();
	}

	@Override
	public Result isUserEmailExists(String email) {
		var isExists = this.usersDao.existsUserByEmail(email);
		if (!isExists) {
			return new ErrorResult("Kullanıcı bulunamadı.");
		}
		return new SuccessResult();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.usersDao.getByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Kullanıcı bulunamadı.");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true, true, true,
				new ArrayList<>());
	}

	@Override
	public UserDto getUserDetailsByEmail(String email) {
		User user = this.usersDao.getByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Kullanıcı bulunamadı.");
		}
		
		return new ModelMapper().map(user, UserDto.class);
	}

}
