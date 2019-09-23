package com.employeeapi.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC004_Put_Employee_Record extends TestBase {

	String empName = RestUtils.empName();
	String empSal = RestUtils.empSal();
	String empAge = RestUtils.empAge();

	@BeforeClass
	void modifyEmployee() throws InterruptedException {
		System.out.println("Child class ka before method");
		logger.info("Starting test case....");

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("name", empName);
		requestParams.put("salary", empSal);
		requestParams.put("age", empAge);
		
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(requestParams.toJSONString());
		
		response = httpRequest.request(Method.PUT, "/update/"+empID);
		
		Thread.sleep(3000);

	}

	
	@Test
	void checkResponseBody(){
		String body = response.getBody().asString();
		Assert.assertTrue(body.contains(empName));
		Assert.assertTrue(body.contains(empSal));
		Assert.assertTrue(body.contains(empAge));
	}
}
