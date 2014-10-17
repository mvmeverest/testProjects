package com.monitoring.model;

public class ServiceModel {

	private String windowsServiceName;
	private boolean windowsServiceRunning;
	private String tomcatServerName;
	private String tomcatServerJMXPort;
	private String tomcatServiceName;
	private boolean tomcatServiceRunning;

	public ServiceModel() {

	}

	public String getWindowsServiceName() {
		return windowsServiceName;
	}

	public void setWindowsServiceName(String windowsServiceName) {
		this.windowsServiceName = windowsServiceName;
	}

	public boolean getWindowsServiceRunning() {
		return windowsServiceRunning;
	}

	public void setWindowsServiceRunning(boolean windowsServiceRunning) {
		this.windowsServiceRunning = windowsServiceRunning;
	}

	public String getTomcatServerName() {
		return tomcatServerName;
	}

	public void setTomcatServerName(String tomcatServerName) {
		this.tomcatServerName = tomcatServerName;
	}

	public String getTomcatServerJMXPort() {
		return tomcatServerJMXPort;
	}

	public void setTomcatServerJMXPort(String tomcatServerJMXPort) {
		this.tomcatServerJMXPort = tomcatServerJMXPort;
	}

	public String getTomcatServiceName() {
		return tomcatServiceName;
	}

	public void setTomcatServiceName(String tomcatServiceName) {
		this.tomcatServiceName = tomcatServiceName;
	}

	public boolean isTomcatServiceRunning() {
		return tomcatServiceRunning;
	}

	public void setTomcatServiceRunning(boolean tomcatServiceRunning) {
		this.tomcatServiceRunning = tomcatServiceRunning;
	}

}
