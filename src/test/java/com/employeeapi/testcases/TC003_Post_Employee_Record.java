package com.employeeapi.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC003_Post_Employee_Record extends TestBase {

	String empName = RestUtils.empName();
	String empSal = RestUtils.empSal();
	String empAge = RestUtils.empAge();

	@BeforeClass
	public void createEmployee() throws InterruptedException {

		logger.info("Starting TC003_Post_Employee_Record");

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();

		requestParams.put("name", empName);
		requestParams.put("salary", empSal);
		requestParams.put("age", empAge);

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());

		response = httpRequest.request(Method.POST, "/create");

		Thread.sleep(3000);
	}

	@Test
	public void checkResponseBody() {

		String body = response.getBody().asString();

		Assert.assertEquals(body.contains(empName), true);
		Assert.assertEquals(body.contains(empAge), true);
		Assert.assertEquals(body.contains(empSal), true);

	}

	@Test
	public void checkStatusCode(){
		int statusCode = response.getStatusCode();
		Assert.assertTrue(statusCode==200);
	}
	
	@Test
	public void checkStatusLine(){
		String statusLine = response.getStatusLine();
		Assert.assertTrue(statusLine.equals("HTTP/1.1 200 OK"));
	}
	
	@Test
	public void checkContentType(){
		String contentType = response.getHeader("Content-Type");
		Assert.assertTrue(contentType.equals("text/html; charset=UTF-8"));
	}
	
	@Test
	public void checkServer(){
		
		String serverType = response.getHeader("Server");
	}
	
	@Test
	public void checkContentEncoding(){
		String contentEncoding = response.getHeader("Content-Encoding");
	}
	
	@Test
	public void checkContentLength(){
		String contentLength = response.getHeader("Content-Length");
	}
	
	@Test
	public void checkSuccessCode(){
		String successCode = response.getHeader("Success-Code");
	}
}
