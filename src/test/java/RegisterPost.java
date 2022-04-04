import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;
import static org.hamcrest.Matcher.*;
import static io.restassured.RestAssured.*;


public class RegisterPost {
    File jsonData;
    String tokenG;

    @BeforeClass
    public void post_data()
    {

        jsonData = new File("C:\\Users\\suhasm\\Desktop\\core\\postman\\MainAssignment\\src\\test\\resources\\postData.json");
        RestAssured.baseURI="https://api-nodejs-todolist.herokuapp.com/user";

    }

    @Test(priority = 1)
    public void testPost()
    {
        given()
                .contentType("application/json")
                .body(jsonData)
                .when()
                .post("/register")
                .then()
                .statusCode(201);
    }

    @Test(priority = 2)
    public void Authenticate() throws IOException {
        baseURI = "https://api-nodejs-todolist.herokuapp.com";
        RequestSpecification request = RestAssured.given();
        String loginDetails="{\n" +
                "  \n" +
                "  \"email\":\"suhas6@gmail.com\",\n" +
                "  \"password\":\"12345678\"\n" +
                "  \n" +
                "}";
        request.header("Content-Type", "application/json");
        Response responseG = request.body(loginDetails).post("/user/login");
        responseG.prettyPrint();
        String jsonString=responseG.getBody().asString();
        tokenG= JsonPath.from(jsonString).get("token");
        System.out.println(tokenG);
    }
}