package com.monitoring.model;

import java.util.List;
import com.monitoring.model.ServiceModel;

public class ServiceModelResponse {

	public ServiceModelResponse() {
	}

	public List<ServiceModel> getServiceInfo() {
		return serviceInfo;
	}

	public void setServiceInfo(List<ServiceModel> serviceInfo) {
		this.serviceInfo = serviceInfo;
	}

	private List<ServiceModel> serviceInfo;

}
