package Authorizations;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Auth {
  @Test
  public void A_basic()
  {
	  
	  given()
	  		.auth().basic("postman","password")
	  .when()
	  		.get("https://postman-echo.com/basic-auth")
	  .then()
	  	.statusCode(200)
	  //	.body("authorticated",equalTo(true))
	  	.log().all();
	  
  }
}
