package org.example;


// Get public toilets, and print them out
// https://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java
// https://hotell.difi.no/api/json/stavanger/offentligetoalett?
// https://github.com/google/gson


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        String sURL = "https://hotell.difi.no/api/json/stavanger/offentligetoalett?"; //just a string

        // Connect to the URL using java's native library
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.connect();

        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.

        //String zipcode = rootobj.get("zip_code").getAsString();
        System.out.println("Hello world!");
        System.out.println(rootobj.getAsString());
    }
}


