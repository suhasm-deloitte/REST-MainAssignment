import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Negative extends AddTask {

    @Test(priority = 7)
    public void repeat_user(){

        JSONObject jsonData = arr.get(new Random().nextInt(arr.size()));

        Response response = given().baseUri("https://api-nodejs-todolist.herokuapp.com/user")
                .contentType("application/json")
                .body(jsonData.toString())
                .when()
                .post("/register")
                .then().statusCode(400).extract().response();


        String error_msg = response.getBody().asString();
        System.out.println(error_msg);
        System.out.println("Error Message Successfully Printed");
    }


    @Test(priority = 8)
    public void invalid_login() throws IOException {

        String invalid_login_path = "C:\\Users\\suhasm\\Desktop\\core\\new\\MainAssignment\\src\\test\\resources\\invalidUser.xlsx";

        baseURI = "https://api-nodejs-todolist.herokuapp.com";
        RequestSpecification request = RestAssured.given();

        String[] loginDetails = base.login_details(invalid_login_path);

        request.header("Content-Type", "application/json");
        Response responseG = request.body(loginDetails).post("/user/login");
        int statusCode = responseG.statusCode();
        String error = responseG.getBody().asString();
        String expected_error = "\"Unable to login\"";
        if((statusCode == 400) && (error.equals(expected_error))){
            System.out.println("Error printed successful");
        }
    }
}