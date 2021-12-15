package com.appsdeveloperblog.rentacar.users.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateCustomerSearchListDto {
	
	private int id;
	private String companyName;
	private String taxNumber;
	private String email;
	private String password;

}
