package com.employeeapi.testcases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileReader reader = new FileReader("data.properties");
		Properties prop = new Properties();
		
		prop.load(reader);
		
		String value = prop.getProperty("name");
		System.out.println(value);
	}

}
