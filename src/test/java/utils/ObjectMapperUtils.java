package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ObjectMapperUtils {

    //This method will accept json data as String, then convert it any data type
    public static <T> T convertJsonToJavaObject(String json, Class<T> cls) {//Generic Method
        try {
            return new ObjectMapper().readValue(json, cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}