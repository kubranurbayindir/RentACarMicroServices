package com.appsdeveloperblog.rentacar.users.business.requests.individualRequests;

import java.time.LocalDate;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateIndividualCustomerRequest {
	
	@JsonIgnore
	private int id;
	
	@NotNull
	@Size(min = 2,max = 10)
	private String firstName;
	
	@NotNull
	@Size(min = 2,max = 10)
	private String lastName;
	
	@NotNull
	private LocalDate birthdate;
	
	@Email
	@NotNull
	@NotBlank
	private String email;
	
	@NotNull
	@NotBlank
	@Size(min = 6, max = 20)
	private String password;
}
