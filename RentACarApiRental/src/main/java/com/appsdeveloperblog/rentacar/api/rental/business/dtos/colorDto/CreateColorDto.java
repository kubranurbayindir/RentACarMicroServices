package com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateColorDto {
	
	@NotNull @Size(min = 2,max = 25)
	private String colorName;

}
