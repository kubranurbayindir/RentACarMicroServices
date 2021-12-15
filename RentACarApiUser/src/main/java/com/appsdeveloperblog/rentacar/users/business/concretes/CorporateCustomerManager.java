package com.appsdeveloperblog.rentacar.users.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.rentacar.users.business.abstracts.CorporateCustomerService;
import com.appsdeveloperblog.rentacar.users.business.dtos.CorporateCustomerSearchListDto;
import com.appsdeveloperblog.rentacar.users.business.requests.corporateCustomerRequests.CreateCorporateCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.corporateCustomerRequests.DeleteCorporateCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.corporateCustomerRequests.UpdateCorporateCustomerRequest;
import com.appsdeveloperblog.rentacar.users.core.utils.mapping.ModelMapperService;
import com.appsdeveloperblog.rentacar.users.core.utils.results.DataResult;
import com.appsdeveloperblog.rentacar.users.core.utils.results.Result;
import com.appsdeveloperblog.rentacar.users.core.utils.results.SuccessDataResult;
import com.appsdeveloperblog.rentacar.users.core.utils.results.SuccessResult;
import com.appsdeveloperblog.rentacar.users.dataAccess.CorporateCustomerDao;
import com.appsdeveloperblog.rentacar.users.entities.CorporateCustomer;

@Service
public class CorporateCustomerManager implements CorporateCustomerService {
	
	
	private CorporateCustomerDao corporateCustomerDao;
	private ModelMapperService modelMapperService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Autowired
	public CorporateCustomerManager(CorporateCustomerDao corporateCustomerDao, ModelMapperService modelMapperService,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.corporateCustomerDao = corporateCustomerDao;
		this.modelMapperService = modelMapperService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public Result add(CreateCorporateCustomerRequest createCorporateCustomerRequest) {
		createCorporateCustomerRequest.setPassword(this.bCryptPasswordEncoder.encode(createCorporateCustomerRequest.getPassword()));
		CorporateCustomer corporateCustomer = modelMapperService.forRequest().map(createCorporateCustomerRequest,
				CorporateCustomer.class);
		this.corporateCustomerDao.save(corporateCustomer);
		return new SuccessResult("Kullanıcı eklendi.");
	}

	@Override
	public Result update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
		updateCorporateCustomerRequest.setPassword(this.bCryptPasswordEncoder.encode(updateCorporateCustomerRequest.getPassword()));
		CorporateCustomer corporateCustomer = modelMapperService.forRequest().map(updateCorporateCustomerRequest,
				CorporateCustomer.class);
		this.corporateCustomerDao.save(corporateCustomer);
		return new SuccessResult("Kullanıcı güncellendi.");
	}

	@Override
	public Result delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest) {
		CorporateCustomer corporateCustomer = modelMapperService.forRequest().map(deleteCorporateCustomerRequest,
				CorporateCustomer.class);
		this.corporateCustomerDao.delete(corporateCustomer);
		return new SuccessResult("Kullanıcı silindi.");
	}

	@Override
	public DataResult<CorporateCustomerSearchListDto> getById(int corporateCustomerId) {
		CorporateCustomer corporateCustomer = this.corporateCustomerDao.getById(corporateCustomerId);
		CorporateCustomerSearchListDto corporateCustomerSearchListDto = modelMapperService.forDto()
				.map(corporateCustomer, CorporateCustomerSearchListDto.class);
		return new SuccessDataResult<CorporateCustomerSearchListDto>(corporateCustomerSearchListDto,
				"Veri getirildi.");
	}

	@Override
	public DataResult<List<CorporateCustomerSearchListDto>> getAll() {
		List<CorporateCustomer> result = this.corporateCustomerDao.findAll();
		List<CorporateCustomerSearchListDto> response = result.stream().map(corporateCustomer -> modelMapperService
				.forDto().map(corporateCustomer, CorporateCustomerSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<CorporateCustomerSearchListDto>>(response);
	}

}
