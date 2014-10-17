package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.services.validators.AdresValidator;
import com.webservices.Adres;
import com.webservices.adresservice.AdresRequest;

@Service
public class AdresServiceImpl implements AdresService {

	@Autowired
	private AdresCompleteServiceImpl adresCompleteService;

	@Override
	public Adres getAdres(AdresRequest request) {
		Adres adres = validateAdres(request, new Adres());
		adres = completeAdres(adres);
		return adres;
	}

	private Adres validateAdres(AdresRequest request, Adres adres) {
		boolean adresValid = AdresValidator.validateAdres(request.getAdres());
		boolean postcodeValid = AdresValidator.validatePostcode(request.getPostcode());

		adres.setAdresValid(adresValid);
		if (!StringUtils.isEmpty(request.getPostcode())) {
			adres.setPostcodeValid(postcodeValid);
		}
		return adres;
	}

	private Adres completeAdres(Adres adres) {
		if (adres.isPostcodeValid()) {
			return adresCompleteService.complete(adres);
		}
		return adres;
	}
}
