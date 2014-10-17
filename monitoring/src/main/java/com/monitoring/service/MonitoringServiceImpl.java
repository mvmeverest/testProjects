package com.monitoring.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.monitoring.model.ServiceModel;
import com.monitoring.service.ConfigurationService;
import com.monitoring.service.MonitoringService;

@Service
public class MonitoringServiceImpl implements MonitoringService {

	@Autowired
	private ConfigurationService configurationService;

	public List<ServiceModel> getServices() {
		List<ServiceModel> serviceModels = configurationService.readConfig();
		for (ServiceModel serviceModel : serviceModels) {
			String windowsServiceName = serviceModel.getWindowsServiceName();
			serviceModel.setWindowsServiceRunning(isWindowsServiceRunning(windowsServiceName));
			if (serviceModel.getWindowsServiceRunning()) {
				serviceModel.setTomcatServiceRunning(isTomcatDeploymentRunning(serviceModel.getTomcatServerName(),
						serviceModel.getTomcatServerJMXPort(), serviceModel.getTomcatServiceName()));
			}
		}

		return serviceModels;
	}

	public boolean isWindowsServiceRunning(String windowsServiceName) {

		String line;
		String scOutput = "";

		try {
			Process process = new ProcessBuilder("C:\\Windows\\System32\\sc.exe", "query", windowsServiceName).start();
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			// Append the buffer lines into one string
			while ((line = br.readLine()) != null) {
				scOutput += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (scOutput.contains("STATE")) {
			if (scOutput.contains("RUNNING")) {
				return true;
			} else {
				return false;
			}
		} else {
			System.out.println("Unknown service");
		}
		return false;
	}

	public boolean isTomcatDeploymentRunning(String tomcatServerName, String tomcatServerJMXPort, String tomcatServiceName) {
		JMXServiceURL url;
		try {
			url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + tomcatServerName + ":" + tomcatServerJMXPort + "/jmxrmi");
			JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
			MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
			ObjectName objectname = new ObjectName("Catalina:j2eeType=WebModule,name=//" + tomcatServerName + "/" + tomcatServiceName
					+ ",J2EEApplication=none,J2EEServer=none");
			Object attribute = mbsc.getAttribute(objectname, "stateName");
			String state = attribute.toString();
			if (state.equals("STARTED")) {
				return true;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (MalformedObjectNameException e) {
			e.printStackTrace();
		} catch (AttributeNotFoundException e) {
			e.printStackTrace();
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		} catch (MBeanException e) {
			e.printStackTrace();
		} catch (ReflectionException e) {
			e.printStackTrace();
		}
		return false;
	}
}
