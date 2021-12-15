package com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarDto {
	
	@NotNull @Positive
	private int brandId;
	@NotNull @Positive
	private int colorId;
	@NotNull @PositiveOrZero
	private double dailyPrice;
	@Min(1890) @Max(2021)
	private int modelYear;
	@Size(min = 2,max = 25)
	private String description;

}
