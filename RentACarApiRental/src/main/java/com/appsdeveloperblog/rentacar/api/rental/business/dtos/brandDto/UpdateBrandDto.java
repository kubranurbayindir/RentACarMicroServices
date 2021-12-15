package com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandDto {
	
	@NotNull @Positive
	private int id;
	
	@NotNull @NotBlank @Size(min = 2,max = 25)
	private String brandName;
	

}
