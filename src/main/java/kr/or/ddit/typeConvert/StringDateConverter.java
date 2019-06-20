package kr.or.ddit.typeConvert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringDateConverter implements Converter<String, Date> {

	private String pattern = "yyyy-MM-dd";

	@Override
	public Date convert(String source) {
		//source : 2019-08-08 이걸 데이트 타입으로 어떻게 바꿀건가
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = null;
		try {
			dt = sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
