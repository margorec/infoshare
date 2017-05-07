package ws.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class GoogleTranslate {

    private final String API_KEY;

    public GoogleTranslate(String api_key) {
        API_KEY = api_key;
    }

    public String translationFor(String input) {
       return null;
    }


}
