package com.monitoring.service;

import java.util.List;
import com.monitoring.model.ServiceModel;

public interface MonitoringService {

	public abstract List<ServiceModel> getServices();

	public abstract boolean isWindowsServiceRunning(String windowsServiceName);

	public abstract boolean isTomcatDeploymentRunning(String tomcatServerName, String tomcatServerJMXPort, String tomcatServiceName);

}