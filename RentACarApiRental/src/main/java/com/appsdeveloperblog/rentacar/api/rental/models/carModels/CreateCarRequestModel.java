package com.appsdeveloperblog.rentacar.api.rental.models.carModels;


import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequestModel {
	
	@JsonIgnore
	private int id;
	
	@NotNull @Positive
	private int brandId;
	@NotNull @Positive
	private int colorId;
	@NotNull @Min(0) @PositiveOrZero
	private double dailyPrice;
	@Min(value = 1890) @Max(value = 2021)
	private int modelYear;
	@Size(min = 2,max = 50 )
	private String description;

}
