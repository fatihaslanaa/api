package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

    public Map<String, String> bookingdatesMapMethod(String checkin,String checkout){

        Map<String, String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin", checkin);
        bookingdatesMap.put("checkout", checkout);

        return bookingdatesMap;
    }
    public Map<String,Object> expectedDataMethod(String firstname, String lastname,
                                                 Integer totalprice, Boolean depositpaid,
                                                 Map<String, String> bookingdatesMap, String additionalneeds){
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingdatesMap);
        expectedData.put("additionalneeds", additionalneeds);

        return expectedData;
    }
}

