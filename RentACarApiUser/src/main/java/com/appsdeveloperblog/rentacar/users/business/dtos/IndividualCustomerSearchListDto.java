package com.appsdeveloperblog.rentacar.users.business.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualCustomerSearchListDto {
	
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate birthdate;
	private String email;
	private String password;
	
	
}
