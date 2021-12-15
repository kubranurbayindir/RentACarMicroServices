package com.appsdeveloperblog.rentacar.users.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.rentacar.users.business.abstracts.IndividualCustomerService;
import com.appsdeveloperblog.rentacar.users.business.dtos.IndividualCustomerSearchListDto;
import com.appsdeveloperblog.rentacar.users.business.requests.individualRequests.CreateIndividualCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.individualRequests.DeleteIndividualCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.individualRequests.UpdateIndividualCustomerRequest;
import com.appsdeveloperblog.rentacar.users.core.utils.mapping.ModelMapperService;
import com.appsdeveloperblog.rentacar.users.core.utils.results.DataResult;
import com.appsdeveloperblog.rentacar.users.core.utils.results.Result;
import com.appsdeveloperblog.rentacar.users.core.utils.results.SuccessDataResult;
import com.appsdeveloperblog.rentacar.users.core.utils.results.SuccessResult;
import com.appsdeveloperblog.rentacar.users.dataAccess.IndividualCustomerDao;
import com.appsdeveloperblog.rentacar.users.entities.IndividualCustomer;

@Service
public class IndividualCustomerManager implements IndividualCustomerService {
	
	private IndividualCustomerDao individualCustomerDao;
	private ModelMapperService modelMapperService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Autowired
	public IndividualCustomerManager(IndividualCustomerDao individualCustomerDao, ModelMapperService modelMapperService,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.individualCustomerDao = individualCustomerDao;
		this.modelMapperService = modelMapperService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public Result add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
		createIndividualCustomerRequest.setPassword(this.bCryptPasswordEncoder.encode(createIndividualCustomerRequest.getPassword()));
		IndividualCustomer individualCustomer = modelMapperService.forRequest().map(createIndividualCustomerRequest,IndividualCustomer.class);
		this.individualCustomerDao.save(individualCustomer);
		return new SuccessResult("Bireysel müşteri eklendi.");
	}

	@Override
	public Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
		updateIndividualCustomerRequest.setPassword(this.bCryptPasswordEncoder.encode(updateIndividualCustomerRequest.getPassword()));
		IndividualCustomer individualCustomer=modelMapperService.forRequest().map(updateIndividualCustomerRequest, IndividualCustomer.class);
		this.individualCustomerDao.save(individualCustomer);
		return new SuccessResult("Bireysel müşteri bilgisi güncellendi.");
	}

	@Override
	public Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
		IndividualCustomer individualCustomer=modelMapperService.forRequest().map(deleteIndividualCustomerRequest, IndividualCustomer.class);
		this.individualCustomerDao.delete(individualCustomer);
		return new SuccessResult("Bireysel müşteri bilgisi silindi.");
	}

	@Override
	public DataResult<IndividualCustomerSearchListDto> getById(int individualCustomerId) {
		IndividualCustomer individualCustomer = this.individualCustomerDao.getById(individualCustomerId);
		IndividualCustomerSearchListDto customerSearchListDto = modelMapperService.forDto().map(individualCustomer,IndividualCustomerSearchListDto.class);
			return new SuccessDataResult<IndividualCustomerSearchListDto>(customerSearchListDto);
	}

	@Override
	public DataResult<List<IndividualCustomerSearchListDto>> getAll() {
		List<IndividualCustomer> result = this.individualCustomerDao.findAll();
		List<IndividualCustomerSearchListDto> response = result.stream().map(individualCustomer->modelMapperService.forDto().map(individualCustomer,IndividualCustomerSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<IndividualCustomerSearchListDto>>(response);
	}

}
