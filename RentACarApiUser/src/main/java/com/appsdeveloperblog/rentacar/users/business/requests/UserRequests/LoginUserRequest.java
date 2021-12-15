package com.appsdeveloperblog.rentacar.users.business.requests.UserRequests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserRequest {
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min = 6,max = 20)
	private String password;
}
