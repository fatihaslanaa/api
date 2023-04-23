package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {





    protected RequestSpecification spec;

    @Before//This method will run before each @test methods
    public void setUp(){

        spec = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();





    }

}
