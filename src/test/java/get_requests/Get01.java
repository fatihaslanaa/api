package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {


/*
        Given
            https://restful-booker.herokuapp.com/booking/10
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
    public void get01(){
//  i) Set the URL
    String url = " https://restful-booker.herokuapp.com/booking/10";

//  ii) Set the expected data

//  iii) Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

//  iv) Do assertion

    response.
            then().
            assertThat().
            statusCode(200).
            contentType("application/json;").
            statusLine("HTTP/1.1 200 OK");




    }

    public static class RequestAndResponse {

        /*
        1) Postman is used for manual API testing
        2) We use RestAssured library for API Automation Testing
        3) To type automation script follow these steps:
           a) Understand the requirement
           b) Type test cases
              To type the test cases we use 'Gherkin Language'
              The keywords are: x) Given: It is used for pre-condition
                                y) When: It is use for actions(Requests...)
                                z) Then: It is use for output(Assertion...)
                                t) And:  It is use for multiple usage of Given, When, Then
            c) Start to type Automation Script
               i) Set the URL
               ii) Set the expected data
               iii) Send the request and get the response
               iv) Do assertion
         */


        /*
            Given
                https://restful-booker.herokuapp.com/booking/10
            When
                User sends a GET Request to the url
            Then
                HTTP Status Code should be 200
            And
                Content Type should be JSON
            And
                Status Line should be HTTP/1.1 200 OK
         */
        public static void main(String[] args) {

            String url =  "https://restful-booker.herokuapp.com/booking/10";

            //User sends a GET Request to the url
            Response response = given().when().get(url);
            response.prettyPrint();

            //HTTP Status Code should be 200
            System.out.println(response.statusCode());

            //Content Type should be JSON
            System.out.println(response.contentType());

            //Status Line should be HTTP/1.1 200 OK"
            System.out.println(response.statusLine());

            //How see "Header" on console:
            System.out.println(response.header("Connection"));

            //How to see "Headers" on console:
            System.out.println(response.headers());

            //How to see "Time" on console:
            System.out.println(response.time());





        }


    }
}

