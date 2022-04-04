import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

@Test(priority = 4)
public class pagination extends AddTask {
    public void page() throws IOException {

        RestAssured.baseURI = "https://api-nodejs-todolist.herokuapp.com";

        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer"+tokenG)
                .header("Content-Type","application/json");

        //

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/task?limit=2");
        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());

        /*Response ResTask = request.post();
        ResTask.prettyPrint()*/;
    }
}
