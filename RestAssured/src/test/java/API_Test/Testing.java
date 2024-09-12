package API_Test;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class Testing {
  @Test(priority = 2)
  public void getResponse() 
  {
	  given()
	  
	  .when()
	  		.get("http://localhost:3000/cats")
	  .then()
	  		.statusCode(200)
	  		.log().all();
	  
  }
  
 // @Test(priority = 1)
  public void postdata()
  {
	  HashMap data = new HashMap();
	  
	  data.put("breed","Ragdoll");
	  data.put("name","Luna");
	  
	  given()
	  		.contentType("application/json")
	  		.body(data)
	  .when()
	  		.post("http://localhost:3000/cats")
	  .then()
	  		.statusCode(201)
	  		.log().all();
  }
  
  @Test(priority = 1)
  public void putdata()
  {
	  HashMap data = new HashMap();
	  
	  data.put("breed","British-sorthair");
	  data.put("name","Luna");
	  
	  given()
	  		.contentType("application/json")
	  		.body(data)
	  .when()
	  		.put("http://localhost:3000/cats/f43b")
	  .then()
	  		.statusCode(200)
	  		.body("breed",equalTo("British-sorthair"))
	  		.log().all();
  }
  
  @Test
  public void deletedata()
  {
	  given()
	  
	  .when()
	  		.put("http://localhost:3000/cats/f43b")	 
	  .then()
	  		.statusCode(200)
	  		.log().all();
	  
  }
}


