package gmibank_api;

import base_urls.GmiBankBaseUrl;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Country;
import pojos.States;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class PostCountry extends GmiBankBaseUrl {
    //Type an automation test that creates a "country" which includes at least 3 "states" using the document //https://app.swaggerhub.com/apis/yasinaniltechpro/GmiBank/0.0.1
    /*
    Given
        https://gmibank.com/api/tp-countries
    And
        {
          "name": "My Country",
          "states": [
            {
              "id": 0,
              "name": "My State"
            },
            {
              "id": 1,
              "name": "Your State"
            },
            {
              "id": 2,
              "name": "Her State"
            }
          ]
        }
     When
        Send post request
     Then
        Status code should be 201
     And
        Response body should be like:
        {
    "id": 181971,
    "name": "My Country",
    "states": [
                {
                    "id": 0,
                    "name": "My State",
                    "tpcountry": null
                },
                {
                    "id": 1,
                    "name": "Your State",
                    "tpcountry": null
                },
                {
                    "id": 2,
                    "name": "Her State",
                    "tpcountry": null
                }
            ]
           }
     */

    @Test
    public void postCountryTest() {
        //Set the url
        spec.pathParams("first", "api", "second", "tp-countries");

        //Set the expected data
        States state1 = new States(0, "My State");
        States state2 = new States(1, "Your State");
        States state3 = new States(2, "Her State");

        List<States> statesList = new ArrayList<>();
        statesList.add(state1);
        statesList.add(state2);
        statesList.add(state3);

        Country expectedData = new Country("My Country", statesList);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

        //Do assertion

        //1st Validation:
        response.
                then().
                statusCode(201).
                body("name", equalTo(expectedData.getName()),
                        "states.id[0]", equalTo(expectedData.getStates().get(0).getId()),
                        "states.name[0]", equalTo(expectedData.getStates().get(0).getName()),
                        "states.id[1]", equalTo(expectedData.getStates().get(1).getId()),
                        "states.name[1]", equalTo(expectedData.getStates().get(1).getName()),
                        "states.id[2]", equalTo(expectedData.getStates().get(2).getId()),
                        "states.name[2]", equalTo(expectedData.getStates().get(2).getName())
                );

        //2nd Validation:
        JsonPath jsonPath = response.jsonPath();

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getName(), jsonPath.getString("name"));
        assertEquals(expectedData.getStates().get(0).getId(), jsonPath.getList("states.id").get(0));
        assertEquals(expectedData.getStates().get(0).getName(), jsonPath.getList("states.name").get(0));
        assertEquals(expectedData.getStates().get(1).getId(), jsonPath.getList("states.id").get(1));
        assertEquals(expectedData.getStates().get(1).getName(), jsonPath.getList("states.name").get(1));
        assertEquals(expectedData.getStates().get(2).getId(), jsonPath.getList("states.id").get(2));
        assertEquals(expectedData.getStates().get(2).getName(), jsonPath.getList("states.name").get(2));

        //3rd Validation:
        Map<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);

        assertEquals(expectedData.getName(), actualDataMap.get("name"));
        assertEquals(expectedData.getStates().get(0).getId(), ((Map) ((List<Object>) actualDataMap.get("states")).get(0)).get("id"));
        assertEquals(expectedData.getStates().get(0).getName(), ((Map) ((List<Object>) actualDataMap.get("states")).get(0)).get("name"));
        assertEquals(expectedData.getStates().get(1).getId(), ((Map) ((List<Object>) actualDataMap.get("states")).get(1)).get("id"));
        assertEquals(expectedData.getStates().get(1).getName(), ((Map) ((List<Object>) actualDataMap.get("states")).get(1)).get("name"));
        assertEquals(expectedData.getStates().get(2).getId(), ((Map) ((List<Object>) actualDataMap.get("states")).get(2)).get("id"));
        assertEquals(expectedData.getStates().get(2).getName(), ((Map) ((List<Object>) actualDataMap.get("states")).get(2)).get("name"));

        //4th Validation
        Country actualDataAsPojo = response.as(Country.class);

        assertEquals(expectedData.getName(), actualDataAsPojo.getName());
        assertEquals(expectedData.getStates().get(0).getId(), actualDataAsPojo.getStates().get(0).getId());
        assertEquals(expectedData.getStates().get(0).getName(), actualDataAsPojo.getStates().get(0).getName());
        assertEquals(expectedData.getStates().get(1).getId(), actualDataAsPojo.getStates().get(1).getId());
        assertEquals(expectedData.getStates().get(1).getName(), actualDataAsPojo.getStates().get(1).getName());
        assertEquals(expectedData.getStates().get(2).getId(), actualDataAsPojo.getStates().get(2).getId());
        assertEquals(expectedData.getStates().get(2).getName(), actualDataAsPojo.getStates().get(2).getName());

        //5th Validation
        Country actualDataPojo = ObjectMapperUtils.convertJsonToJavaObject(response.asString(), Country.class);

        assertEquals(expectedData.getName(), actualDataPojo.getName());
        assertEquals(expectedData.getStates().get(0).getId(), actualDataPojo.getStates().get(0).getId());
        assertEquals(expectedData.getStates().get(0).getName(), actualDataPojo.getStates().get(0).getName());
        assertEquals(expectedData.getStates().get(1).getId(), actualDataPojo.getStates().get(1).getId());
        assertEquals(expectedData.getStates().get(1).getName(), actualDataPojo.getStates().get(1).getName());
        assertEquals(expectedData.getStates().get(2).getId(), actualDataPojo.getStates().get(2).getId());
        assertEquals(expectedData.getStates().get(2).getName(), actualDataPojo.getStates().get(2).getName());

        //6th Validation: ==> Gson
        Country actualDataGson = new Gson().fromJson(response.asString(), Country.class);
        System.out.println("actualDataGson = " + actualDataGson);

        assertEquals(expectedData.getName(), actualDataGson.getName());
        assertEquals(expectedData.getStates().get(0).getId(), actualDataGson.getStates().get(0).getId());
        assertEquals(expectedData.getStates().get(0).getName(), actualDataGson.getStates().get(0).getName());
        assertEquals(expectedData.getStates().get(1).getId(), actualDataGson.getStates().get(1).getId());
        assertEquals(expectedData.getStates().get(1).getName(), actualDataGson.getStates().get(1).getName());
        assertEquals(expectedData.getStates().get(2).getId(), actualDataGson.getStates().get(2).getId());
        assertEquals(expectedData.getStates().get(2).getName(), actualDataGson.getStates().get(2).getName());

    }
}