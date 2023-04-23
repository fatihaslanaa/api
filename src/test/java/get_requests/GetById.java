package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetById {


    public class GetByID extends HerOkuAppBaseUrl {
/*
Given
  https://restful-booker.herokuapp.com/booking/246
When
  I send GET Request to the url
Then
  Response body should be like that;
  {
    "firstname": "John",
    "lastname": "Smith",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Dinner"
}
 */

        @Test
        public void get09(){

            //Set the URL
            spec.pathParams("first","booking","second",1712);

            //Set the expected data

            //Send the request and get the response
            Response response = given().spec(spec).when().get("/{first}/{second}");
            response.prettyPrint();

            //Do assertion
            response.then().body("firstname",equalTo("John"),
                    "lastname",equalTo("Smith"),
                    "totalprice",equalTo(111),
                    "depositpaid",equalTo(true),
                    "bookingdates.checkin",equalTo("2018-01-01"),
                    "bookingdates.checkout",equalTo("2019-01-01"),
                    "additionalneeds",equalTo("Breakfast"));













        }


    }






}
