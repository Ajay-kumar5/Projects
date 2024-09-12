package PostResquestPayload;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.concurrent.LinkedTransferQueue;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Post_Test {
 
	String id;
	
	//@Test
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
		  		.body("breed",equalTo("Ragdoll"))
		  		.body("name",equalTo("Luna"))
		  		.log().all();
	  }
  
  @Test
  public void POJOdata()
  {
	  POJO data = new POJO();
	  
	  data.setBreed("Ragdoll");
	  data.setName("Luna");
	  String Food[] = {"Fish","Meat"};

	  data.setFavFood(Food);
	  
	  
	  id=  given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/cats")
			.jsonPath().getString("id");
//		.then()
//			.statusCode(201)
//			.body("breed",equalTo("Ragdoll"))
//			.body("name",equalTo("Luna"))
//			.body("favFood[0]",equalTo("Fish"))
//			.body("favFood[1]",equalTo("Meat"))
//			.log().all();
}
  
	
	 @Test
	  public void deletedata()
	  {
		  given()
		  
		  .when()
		  		.delete("http://localhost:3000/cats/"+"id")	 
		  .then()
		  		.statusCode(200)
		  		.log().all();
		  
	  }
	}
  

