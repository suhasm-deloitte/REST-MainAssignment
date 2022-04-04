import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class AddTask extends RegisterPost {

    @Test(priority = 3)
    public void addTask(){
        RestAssured.baseURI = "https://api-nodejs-todolist.herokuapp.com";
        RequestSpecification request = RestAssured.given();

        request.header("Authorization","Bearer "+tokenG)
                .header("Content-Type","application/json");
        String addTask="{\n" +
                "\t\"description\": \"reading book2\"\n" +
                "}";
        Response ResponseaddTask=request.body(addTask).post("/task");
        ResponseaddTask.prettyPrint();

    }
}