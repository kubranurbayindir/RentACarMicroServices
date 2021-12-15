package com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCarDto {
	
	@NotNull @Positive
	private int id;

}
