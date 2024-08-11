package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.response.Response;
import pojos.Airline;
import pojos.ConvertPojo;
import pojos.CreateAirline;
import rest.Context;
import rest.EContentType;
import rest.Methods;

public class TestClass extends BaseTest {

	Logger logger = LogManager.getLogger(TestClass.class);

	@Test(dataProvider = "scenarios", dataProviderClass = util.MyDataProvider.class)
	public void test00(String scenario, String expStatusCode, String expMessage) throws JsonProcessingException {

		Airline airline = CreateAirline.createAirline();
		logger.info("***Airline object is created***");

		String payload = "";

		switch (scenario) {
		case "create with valid payload":
			payload = ConvertPojo.filteredjacksonConvert(airline, scenario);
			break;
		case "create with empty body":
			payload = ConvertPojo.filteredjacksonConvert(airline, scenario);
			break;
		case "create without name":
			payload = ConvertPojo.filteredjacksonConvert(airline, scenario);
			break;
		}

		Context context = new Context();
		context.baseURL = "https://api.instantwebtools.net";
		context.URI = "/v1/airlines";
		context.requestContentType = EContentType.JSON;
		context.requestBodyString = payload;
		logger.info("***HTTPRequest Context has been created***");

		Response res = Methods.POST(context);
		logger.info("***Post method has been executed***");
		res.then().log().body().toString();
		logger.info("******Response body**********");
		logger.info(res.getBody().prettyPrint());

		String bodyTxt = "";

		if (scenario.contains("valid")) {
			bodyTxt = "no_data";
		} else {
			bodyTxt = res.jsonPath().getString("message");
		}

		Assert.assertEquals(res.statusCode(), Integer.valueOf(expStatusCode));
		Assert.assertEquals(bodyTxt, expMessage);

		logger.info("***Test is complete***");

	}

}
