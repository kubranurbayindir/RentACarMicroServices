package com.appsdeveloperblog.rentacar.users.core.utils.results;

public class ErrorDataResult<T> extends DataResult<T> {
	
	
	public ErrorDataResult(T data) {
		super(false, data);
	}

	public ErrorDataResult(String message, T data) {
		super(false, data, message);
	}

}
