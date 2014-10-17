package com.services.validators;

public class AdresValidator {

	public static boolean validateAdres(String adres) {
		return adres.matches("^([a-zA-Z ]{3,}) ([0-9]{1,})([a-zA-Z]*)$");
	}

	public static boolean validatePostcode(String postcode) {
		return postcode.matches("^([0-9]{4}) ([a-zA-Z]{2})$");
	}

}