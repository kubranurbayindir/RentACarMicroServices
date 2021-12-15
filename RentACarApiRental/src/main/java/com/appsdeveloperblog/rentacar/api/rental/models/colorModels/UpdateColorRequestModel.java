package com.appsdeveloperblog.rentacar.api.rental.models.colorModels;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateColorRequestModel {
	
	@NotNull
	private int id;
	
	@NotNull @NotBlank @Size(min = 2)
	private String colorName;

}
