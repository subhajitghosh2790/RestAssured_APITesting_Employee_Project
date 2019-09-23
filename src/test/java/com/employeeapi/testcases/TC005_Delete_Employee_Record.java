package com.employeeapi.testcases;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_Delete_Employee_Record extends TestBase {

	@BeforeClass
	void deleteRecord() throws InterruptedException {
		logger.info("Starting Test case for Delete........");

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		httpRequest = RestAssured.given();

		// we will first get all the employee records
		response = httpRequest.request(Method.GET, "/employees");

		// then create JsonPath Object to extract a particular detail
		JsonPath jsonPath = response.jsonPath();

		// here we are extracting the 'id' of the 'first record' in the
		// collection
		String empID = jsonPath.get("[0].id");// [0] is the first record

		// then we are deleting the record with teh empId which has been
		// extracted above.
		// another approach could have been directly passing Empl ID but we are
		// generated emplID at the run time and the and thn deleting it.
		response = httpRequest.request(Method.DELETE, "/delete/" + empID);

		Thread.sleep(3000);
	}

	@Test
	void validateStatusCode() {
		int StatusCode = response.getStatusCode();

		logger.info("Status code is --> " + StatusCode);

		Assert.assertTrue(StatusCode == 200);
	}

	@Test
	void getResponseBody() {

		String responseBody = response.getBody().asString();

		logger.info("Response body --> " + responseBody);
	}

}
