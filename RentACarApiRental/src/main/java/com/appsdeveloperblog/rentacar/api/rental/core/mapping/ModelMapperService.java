package com.appsdeveloperblog.rentacar.api.rental.core.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	
	ModelMapper forDto();
	ModelMapper forRequest();
}
