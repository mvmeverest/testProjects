package com.monitoring.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.monitoring.model.ServiceModel;

@Service
@PropertySource("classpath:application.properties")
public class ConfigurationServiceImpl implements ConfigurationService {

	@Value("${services.path}")
	private String servicesPath;

	public List<ServiceModel> readConfig() {
		List<ServiceModel> serviceModelList = new ArrayList<ServiceModel>();
		try {
			Document doc = createDocument();
			NodeList serviceList = doc.getElementsByTagName("service");
			createServiceModelList(serviceList, serviceModelList);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return serviceModelList;
	}

	private void createServiceModelList(NodeList serviceList, List<ServiceModel> serviceModelList) {
		for (int temp = 0; temp < serviceList.getLength(); temp++) {

			Node serviceNode = serviceList.item(temp);

			if (serviceNode.getNodeType() == Node.ELEMENT_NODE) {

				Element serviceElement = (Element) serviceNode;
				ServiceModel serviceModel = new ServiceModel();
				serviceModel.setWindowsServiceName(serviceElement.getElementsByTagName("windowsServiceName").item(0).getTextContent());
				serviceModel.setTomcatServerName(serviceElement.getElementsByTagName("tomcatServerName").item(0).getTextContent());
				serviceModel.setTomcatServerJMXPort(serviceElement.getElementsByTagName("tomcatServerJMXPort").item(0).getTextContent());
				serviceModel.setTomcatServiceName(serviceElement.getElementsByTagName("tomcatServiceName").item(0).getTextContent());
				serviceModelList.add(serviceModel);
			}
		}
	}

	private Document createDocument() throws MalformedURLException, ParserConfigurationException, SAXException, IOException {
		Resource resource = new UrlResource("file:///" + servicesPath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(resource.getInputStream());
		return doc;
	}
}
