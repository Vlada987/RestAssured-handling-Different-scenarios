package pojos;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonFilter("myFilter")
@JsonPropertyOrder({ "name", "country", "logo", "slogan", "head_quaters", "website", "established" })
public class Airline {

	String name;
	String country;
	String logo;
	String slogan;
	String head_quaters;
	String website;
	String established;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getHead_quaters() {
		return head_quaters;
	}

	public void setHead_quaters(String head_quaters) {
		this.head_quaters = head_quaters;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEstablished() {
		return established;
	}

	public void setEstablished(String established) {
		this.established = established;
	}

}
