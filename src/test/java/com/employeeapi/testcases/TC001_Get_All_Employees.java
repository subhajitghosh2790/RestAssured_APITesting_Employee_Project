package com.employeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Employees extends TestBase {

	@BeforeClass
	public void getAllEmployees() throws InterruptedException {

		logger.info("\n**************   Start    *************************\n"
				+ 	"*		Started TC001_Get_All_Employees 		   *\n"
				+ 	"****************************************************");

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employees");

		Thread.sleep(3000);
	}

	@Test
	public void checkResponseBody() {
		logger.info("********** Checking Response Body *************");

		String responseBody = response.getBody().asString();
		logger.info("Response body is ---> " + responseBody);

		Assert.assertTrue(responseBody != null);
	}

	@Test
	public void checkStatusCode() {
		logger.info("********** Checking Status Code *************");

		int statusCode = response.getStatusCode();
		logger.info("Status Code is ---> " + statusCode);

		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void checkResponseTime() {
		logger.info("********** Checking Response Tome *************");

		int responseTime = (int) response.getTime();
		logger.info("Response body is ---> " + responseTime);

		if (responseTime > 1000)
			logger.warn("Response time was more than 1000 ms");

		Assert.assertTrue(responseTime < 1000);
	}

	@Test
	public void checkStatusLine() {
		logger.info("********** Checking Status Line *************");

		String statusCode = response.getStatusLine();
		logger.info("Status Line is ---> " + statusCode);

		Assert.assertEquals(statusCode, "HTTP/1.1 200 OK");
	}

	@Test
	public void checkContentType() {
		logger.info("********** Checking Content Type *************");

		String contentType = response.header("Content-Type");
		logger.info("Content Type is ---> " + contentType);

		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}

	@Test
	public void checkServerType() {
		logger.info("********** Checking Server Type *************");

		String serverType = response.header("Server");
		logger.info("Content Type is ---> " + serverType);

		Assert.assertEquals(serverType, "nginx/1.14.1");
	}

	@Test
	public void checkContentEncoding() {
		logger.info("********** Checking Content Encoding *************");

		String contentEncoding = response.header("Content-Encoding");
		logger.info("Content Encoding is ---> " + contentEncoding);

		Assert.assertEquals(contentEncoding, "gzip");
	}

	@Test
	public void checkContentLength() {
		logger.info("********** Checking Content Length *************");

		String contentLength = response.header("Content-Length");
		logger.info("Content Length is ---> " + contentLength);

		if (Integer.parseInt(contentLength) > 800)
			logger.warn("Content Length is more than 800");
		Assert.assertTrue(Integer.parseInt(contentLength) < 800);
	}

	@Test
	public void checkCookie() {
		logger.info("********** Checking Cookie *************");

		String cookie = response.getCookie("PHPSESSID");
		logger.info("Cookie generated is ---> " + cookie);

	}

	@AfterClass
	public void afterClass() {
		logger.info("******** Ending TC001_Get_All_Employees *********");
	}

}
