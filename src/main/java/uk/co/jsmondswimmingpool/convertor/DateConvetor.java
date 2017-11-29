package uk.co.jsmondswimmingpool.convertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConvetor  implements Converter<String,Date>{
	
	@Override
	public Date convert(String source) {
//		System.out.println(source);
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parse = dateFormat.parse(source);
			return parse;
			
		} catch (ParseException e) {
		}
		return null;
	}

}
