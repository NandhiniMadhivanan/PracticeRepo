package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.entity.ContentType;

public class ReqResManager {

    public static final RequestSpecification RequestSpec(String baseURI, String path)
    {
        return new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .setBasePath(path)
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
    }

    public static final ResponseSpecification ResponseSpec()
    {
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(200)
                .build();
    }


}
