package com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandSearchListDto {
	
	private int id;
	private String brandName;

}
