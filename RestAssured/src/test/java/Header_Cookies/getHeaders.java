package Header_Cookies;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class getHeaders {
  @Test
  public void H() 
  {
	  given()
	  
	  .when()
	  		.get("http://www.google.com")
	  
	  .then()
	  		.header("Content-Type","text/html; charset=ISO-8859-1")
	  		.and()
	  		.header("Content-Encoding", "gzip")
	  		.and()
	  		.header("Server", "gws");
  }
  
  @Test
  public void H1()
  {
	  
	Response res = given()
	  
	  .when()
	  		.get("http://www.google.com/");
	  
	 Headers head = res.getHeaders();	  
	
	for(Header h : head)
	{
		
		System.out.println(h.getName()+"     "+h.getValue());
	}
  }
}
