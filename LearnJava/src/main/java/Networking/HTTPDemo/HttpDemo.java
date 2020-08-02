package Networking.HTTPDemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpDemo {

    // Sample JSON API URI
    private static final String API_link = "https://jsonplaceholder.typicode.com/todos";

    public static void HTTP_Demo() throws IOException, InterruptedException {

        // First, let's create an HTTPClient
        HttpClient client = HttpClient.newHttpClient();
        /* At this step, we will build a request by using the HTTP
         * method (GET, POSt, PUT etc.) followed by header declaration
         * and then passing the API URI and finally building the request
         * body using the build() method
         */
        HttpRequest req = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(API_link))
                .build();

        /* Now, we'll use the HttpClient object to send the HttpRequest obj,
         * i.e., send a request to the server using the client
         * HttpResponse.BodyHandlers.ofString() is used to fetch the response
         * body as string
         */
        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

        // And finally, parse the response into an object
        // ObjectMapper is used to parse JSON data into an object
        ObjectMapper mapper = new ObjectMapper();

        /*
         * readValues method takes two args
         * 1. response body
         * 2. TypeReference; which basically means what type of JSON are we going to parse
         * */
        List<Todo> todoList = mapper.readValue(res.body(), new TypeReference<List<Todo>>() {
        });

        todoList.forEach((item) -> {
            System.out.println(item);
        });

    }
}
