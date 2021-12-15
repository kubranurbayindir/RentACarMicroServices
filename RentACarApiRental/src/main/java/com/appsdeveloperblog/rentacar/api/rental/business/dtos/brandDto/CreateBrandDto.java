package com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandDto {
	
	@JsonIgnore
	private int id;
	
	@NotBlank
	@NotNull
	@Size(min = 2,max = 25)
	private String brandName;
	
	
	

}
