package pojos;

import util.CreateCountry;

public class CreateAirline {

	public static Airline createAirline() {

		String country = CreateCountry.createCountry();
		Airline airline = new Airline();
		airline.setName(country + " Airways");
		airline.setCountry(country);
		airline.setLogo("https://" + country + "airways.net/logo");
		airline.setSlogan("from " + country + " to anywhere cheap and safe");
		airline.setHead_quaters(country + " Central Airport");
		airline.setWebsite(country + "airways.net");
		airline.setEstablished("2016-23-01");
		return airline;
	}

}
