package com.appsdeveloperblog.rentacar.api.rental.models.brandModels;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequestModel {
	
	@NotNull
	private int id;
	
	@NotNull @NotBlank @Size(min = 2)
	private String brandName;

}
