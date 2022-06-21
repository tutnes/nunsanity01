package org.example;


// Get public toilets, and print them out
// https://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java
// https://hotell.difi.no/api/json/stavanger/offentligetoalett?
// https://github.com/google/gson


import java.io.IOException;
import com.google.gson.Gson;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        System.out.println("Starting program!");
        String sURL = "https://hotell.difi.no/api/json/stavanger/offentligetoalett?"; //just a string

        WebClient webClient = WebClient.create(sURL);
        Mono<String> body = webClient.get().retrieve().bodyToMono(String.class);
        String s = body.block();
        Gson gson = new Gson();
        Object object = gson.fromJson(s, Object.class);
        System.out.println("\n\n\n");
        System.out.println(object.toString());

    }
}


