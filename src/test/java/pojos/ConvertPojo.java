package pojos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class ConvertPojo {

	public static String filteredjacksonConvert(Object obj, String... scenario) throws JsonProcessingException {

		FilterProvider filter = null;

		if (scenario[0].contains("empty body")) {

			filter = new SimpleFilterProvider().addFilter("myFilter", SimpleBeanPropertyFilter.filterOutAll());
		}

		else if (scenario[0].contains("valid")) {

			filter = new SimpleFilterProvider().addFilter("myFilter", SimpleBeanPropertyFilter
					.filterOutAllExcept("name", "country", "logo", "slogan", "head_quaters", "website", "established"));
		} else if (scenario[0].contains("without name")) {

			filter = new SimpleFilterProvider().addFilter("myFilter", SimpleBeanPropertyFilter
					.filterOutAllExcept("country", "logo", "slogan", "head_quaters", "website", "established"));
		}
		ObjectMapper oMapper = new ObjectMapper();
		String data = oMapper.writer(filter).withDefaultPrettyPrinter().writeValueAsString(obj);
		return data;
	}

	public static String jacksonConvert(Object obj) throws JsonProcessingException {

		ObjectMapper oMapper = new ObjectMapper();
		String data = oMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

		return data;
	}

}
