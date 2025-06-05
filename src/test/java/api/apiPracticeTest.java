package api;
import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class apiPracticeTest {

    ReqResManager reqResManager = new ReqResManager();
    String BaseURL = "https://datausa.io";
    String path = "/api";
    Map<String,String> queryParams = new HashMap<String,String>();

    @BeforeTest
    public static void logSetup()
    {
        RestAssured.config = RestAssured.config()
                .logConfig(LogConfig.logConfig()
                        .enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)
                        .enablePrettyPrinting(true));
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    public void exampleTest()
    {
        queryParams.put("drilldowns","Nation");
        queryParams.put("measures","Population");
        Response response = given()
                .spec(reqResManager.RequestSpec(BaseURL,path))
                .config(RestAssured.config().logConfig(LogConfig.logConfig()))
                .queryParams(queryParams)
                .when()
                .get("/data")
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"))
                .spec(reqResManager.ResponseSpec())
                .extract().response();
    }

}
