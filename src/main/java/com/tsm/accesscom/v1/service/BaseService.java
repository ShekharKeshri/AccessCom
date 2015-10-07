package com.tsm.accesscom.v1.service;

import com.maxoptra.api.v1.model.response.ApiResponse;


public interface BaseService {

	public String getAuthenticate(String restUrl, String purpose);
	
	public ApiResponse saveOrder(String restUrl, String purpose, String sessionId);
	
	public ApiResponse getAOC(String restUrl, String purpose);
	
	public ApiResponse getVehicleByDate(String restUrl, String purpose);
}
