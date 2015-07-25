package com.paxotech.qa.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


//https://code.google.com/p/rest-assured/wiki/GettingStarted

public class HeatclinicRestTest {
	
	@BeforeMethod
	public void setUp(){
		RestAssured.baseURI = "http://qa1.paxovision.com/heatclinic/";
		RestAssured.port = 80;
		RestAssured.basePath = "/api/v1";
		//RestAssured.authentication = basic("username", "password");
	}
	
	@Test
	public void test(){
		
		given()
			.log().all()
			.param("q", "hot")
			.param("pageSize", 5)
			.param("page", 1)
			.contentType(ContentType.XML)
			.accept(ContentType.XML)
		.when()
			.get("/catalog/search/products")
		.then()
			.log().body()
			.statusCode(200)
			.body(hasXPath("/searchResults/totalResults", containsString("14")))
			.body(hasXPath("/searchResults/pageSize", equalToIgnoringCase("5")))
			.body(hasXPath("/searchResults/products/product[1]/id", equalToIgnoringCase("13")))
		;
		
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		
	}
	

}
