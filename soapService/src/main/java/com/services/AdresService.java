package com.services;

import com.webservices.Adres;
import com.webservices.adresservice.AdresRequest;

public interface AdresService {
	public Adres getAdres(AdresRequest request);
}
