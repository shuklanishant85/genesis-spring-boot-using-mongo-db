package com.genesis.mongodbservice.utils;

import java.time.YearMonth;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

public class YearMonthConvertor implements GenericConverter {

	ConvertiblePair stringToYearMonth = new ConvertiblePair(String.class, YearMonth.class);
	ConvertiblePair stringToDate = new ConvertiblePair(String.class, Date.class);

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(stringToYearMonth);
		convertiblePairs.add(stringToDate);
		return new HashSet<>(convertiblePairs);
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		YearMonth yearMonth = null;
		if (source instanceof String && source.toString().matches("\\d\\d\\/\\d\\d+")) {
			yearMonth = YearMonth.parse(source.toString());
		}
		return yearMonth;
	}

}
