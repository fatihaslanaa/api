import base_urls.Reqres;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HW1 extends Reqres {
    /*
     Given
         https://reqres.in/api/users/3
     When
         User sends a GET Request to the url
     Then
         HTTP Status Code should be 200
     And
         Content Type should be JSON
     And
         Status Line should be HTTP/1.1 200 OK
  */

    @Test
    public  void Hw01(){
        //Set teh url
        spec.pathParams("first","users","second",3);
        //Set the expected data

        //Sen the request and get the response
       Response response = given().spec(spec).when().get("{first}/{second}");
       response.prettyPrint();

       //do assertion
        assertEquals(200,response.statusCode());
        assertEquals("application/json; charset=utf-8",response.contentType());
        assertEquals("HTTP/1.1 200 OK",response.statusLine());

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
    }
}
