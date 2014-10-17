package com.services.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.services.AdresService;
import com.webservices.Adres;
import com.webservices.adresservice.AdresRequest;
import com.webservices.adresservice.AdresResponse;

@Endpoint
public class AdresServiceEndpoint {
	private static final String TARGET_NAMESPACE = "http://com/webservices/adresService";

	@Autowired
	private AdresService adresService;

	@PayloadRoot(localPart = "AdresRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload AdresResponse getAdresDetails(@RequestPayload AdresRequest request) {
		AdresResponse response = new AdresResponse();
		Adres adres = adresService.getAdres(request);
		response.setAdres(adres);
		return response;
	}
}