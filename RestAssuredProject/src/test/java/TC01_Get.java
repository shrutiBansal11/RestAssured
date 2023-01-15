import org.codehaus.groovy.ast.stmt.ReturnStatement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;


public class TC01_Get {
	@Test
	void test_01() {
		
		
		Response response = get("https://reqres.in/api/users?page=2");
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getBody().asPrettyString());
//		System.out.println(response.getTime());
//		System.out.println(response.getHeader("Content-Type"));
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
				
	}
	@Test
	void test_02()	
	{
		given().
		get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[1]", equalTo(8));
		//Arihant
	}

}
