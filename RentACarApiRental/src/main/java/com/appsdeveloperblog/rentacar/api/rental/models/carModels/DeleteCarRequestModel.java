package com.appsdeveloperblog.rentacar.api.rental.models.carModels;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCarRequestModel {
	
	@NotNull
	private int id;

}
