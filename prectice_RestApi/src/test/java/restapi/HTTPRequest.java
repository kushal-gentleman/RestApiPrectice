package restapi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequest {
	
	private int id;
	
	@Test(priority = 1)
	public void getUser() {
		
		
		given()
		
		
		.when()
		 .get("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}
	
	@Test(priority = 2)
	public void getUsers() {
		
		when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.body("page", equalTo(2))
		.log().all();
		
		
	}

	@Test(priority = 3)
	public void createUser() {
		
		HashMap<String, String> hm=new HashMap<String, String>();
		hm.put("name", "pavan");
		hm.put("job", "trainer");
		
		id=given()
		.contentType("application/json")
		.body(hm)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");;
	
		
	}
	
	@Test(priority = 4)
	public void updateUser() {
		
	HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("name", "ram");
		hm.put("job", "creator");
		
		given()
		.contentType("application/json")
		.body(hm)
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority = 5)
	public void deleteUser() {
		
		when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		.log().all();
	}
}
