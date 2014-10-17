package com.services;

import org.springframework.stereotype.Service;
import com.webservices.Adres;

@Service
public class AdresCompleteServiceImpl implements AdresCompleteService {

	@Override
	public Adres complete(Adres adres) {
		adres.setAdres("Mockadres");
		adres.setPlaats("Mockplaats");
		adres.setAdresNumber("1");
		adres.setAdresValid(true);
		return adres;
	}
}
