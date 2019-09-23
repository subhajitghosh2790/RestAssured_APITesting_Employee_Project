package com.employeeapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class RestUtils {
	
	public static String empName(){
		String generatedString = RandomStringUtils.randomAlphabetic(2);
		return ("John"+generatedString);
	}

	public static String empSal(){
		String randomSal = RandomStringUtils.randomNumeric(5);
		return randomSal;
	}

	public static String empAge(){
		String randomAge = RandomStringUtils.randomNumeric(2);
		return randomAge;
	}

}
