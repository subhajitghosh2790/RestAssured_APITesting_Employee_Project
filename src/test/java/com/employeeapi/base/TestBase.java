package com.employeeapi.base;



import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID = "51838";

	public Logger logger;

	@BeforeClass
	public void setup() {
		System.out.println("PARENT class ka before method");
		logger = Logger.getLogger("EmployeesRestAPI"); // usually project ka
														// naam dalte hai
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
}
