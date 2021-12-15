package com.appsdeveloperblog.rentacar.users.business.abstracts;

import java.util.List;

import com.appsdeveloperblog.rentacar.users.business.dtos.CorporateCustomerSearchListDto;
import com.appsdeveloperblog.rentacar.users.business.dtos.IndividualCustomerSearchListDto;
import com.appsdeveloperblog.rentacar.users.business.requests.corporateCustomerRequests.CreateCorporateCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.corporateCustomerRequests.DeleteCorporateCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.corporateCustomerRequests.UpdateCorporateCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.individualRequests.CreateIndividualCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.individualRequests.DeleteIndividualCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.individualRequests.UpdateIndividualCustomerRequest;
import com.appsdeveloperblog.rentacar.users.core.utils.results.DataResult;
import com.appsdeveloperblog.rentacar.users.core.utils.results.Result;

public interface IndividualCustomerService {
	
	Result add(CreateIndividualCustomerRequest individualCustomerRequest);
	Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);
	Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest);
	DataResult<IndividualCustomerSearchListDto> getById(int individualCustomerId);
	DataResult<List<IndividualCustomerSearchListDto>> getAll();

}
