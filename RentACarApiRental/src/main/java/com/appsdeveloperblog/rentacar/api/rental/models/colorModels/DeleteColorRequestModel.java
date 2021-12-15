package com.appsdeveloperblog.rentacar.api.rental.models.colorModels;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteColorRequestModel {
	
	@NotNull
	private int id;

}
