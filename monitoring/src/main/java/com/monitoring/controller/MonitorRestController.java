package com.monitoring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monitoring.model.ServiceModel;
import com.monitoring.model.ServiceModelResponse;
import com.monitoring.service.MonitoringService;

@RestController
public class MonitorRestController {

	@Autowired
	private MonitoringService monitoringService;

	@RequestMapping("/services")
	public ServiceModelResponse getServices() {
		ObjectMapper mapper = new ObjectMapper();
		List<ServiceModel> services = monitoringService.getServices();
		ServiceModelResponse response = new ServiceModelResponse();
		response.setServiceInfo(services);
		return response;
	}
}