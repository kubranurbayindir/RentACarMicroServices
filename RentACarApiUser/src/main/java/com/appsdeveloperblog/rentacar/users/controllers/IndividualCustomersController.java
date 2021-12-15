package com.appsdeveloperblog.rentacar.users.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.rentacar.users.business.abstracts.IndividualCustomerService;
import com.appsdeveloperblog.rentacar.users.business.dtos.IndividualCustomerSearchListDto;
import com.appsdeveloperblog.rentacar.users.business.requests.individualRequests.CreateIndividualCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.individualRequests.DeleteIndividualCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.individualRequests.UpdateIndividualCustomerRequest;
import com.appsdeveloperblog.rentacar.users.core.utils.results.DataResult;
import com.appsdeveloperblog.rentacar.users.core.utils.results.Result;

@RestController
@RequestMapping("/individualCustomers")
public class IndividualCustomersController {
	
	private IndividualCustomerService individualCustomerService;

	@Autowired
	public IndividualCustomersController(IndividualCustomerService individualCustomerService) {
		super();
		this.individualCustomerService = individualCustomerService;
	}

	@GetMapping("/getAll")
	public DataResult<List<IndividualCustomerSearchListDto>> getAll() {
		return this.individualCustomerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateIndividualCustomerRequest createIndividualCustomerRequest) {
		return this.individualCustomerService.add(createIndividualCustomerRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
		return this.individualCustomerService.delete(deleteIndividualCustomerRequest);
	}

	@PutMapping("/update")
	public Result update(@RequestBody @Valid  UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
		return this.individualCustomerService.update(updateIndividualCustomerRequest);
	}

	@GetMapping("/getByIndividualCustomerById")
	public DataResult<IndividualCustomerSearchListDto> getByIndividualCustomerById(int id) {
		return this.individualCustomerService.getById(id);
	}


}
