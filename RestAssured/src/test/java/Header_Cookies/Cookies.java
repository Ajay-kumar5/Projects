package Header_Cookies;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies {
  @Test
  public void C() 
  {
	  
	 Response res =  given()
	  
	  .when()
	  	.get("http://www.google.com/");
	  
//	 String cookie_one = res.getCookie("AEC");
//	 System.out.println(cookie_one);
	 
	 Map<String,String> allcookie = res.getCookies();
	 
	 System.out.println(allcookie.keySet());
	 
	 for(String x : allcookie.keySet())
	 {
		 String y = res.getCookie(x);
		 System.out.println(y);
	 }
	  
	 
	  
  }
}
