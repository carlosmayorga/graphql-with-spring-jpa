package com.cmayorga.spring.graphql.jpa.schema.dto.utils;

import org.springframework.stereotype.Service;

@Service
public class Utils {

	public String removeSpacesFromDb(String string) {
		return string.replaceAll("\\s+", "");
	}
	
}
