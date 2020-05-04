package org.example.ta.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonConverter {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private JsonConverter() {
        throw new AssertionError("This class was not designed to be instantiated.");
    }

    public static String convertToJson(Object object) {
        return gson.toJson(object);
    }
}
