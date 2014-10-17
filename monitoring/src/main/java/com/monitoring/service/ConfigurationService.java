package com.monitoring.service;

import java.util.List;
import com.monitoring.model.ServiceModel;

public interface ConfigurationService {

	public abstract List<ServiceModel> readConfig();

}