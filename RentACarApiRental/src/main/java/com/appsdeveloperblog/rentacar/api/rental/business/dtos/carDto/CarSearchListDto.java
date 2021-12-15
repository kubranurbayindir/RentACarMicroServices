package com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarSearchListDto {
	
	private int id;
	private int brandId;
	private int colorId;
	private double dailyPrice;
	private int modelYear;
	private String description;
	

}
