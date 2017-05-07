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
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("https://translation.googleapis.com/language/translate/v2?key=" + API_KEY + "&source=en&target=pl&q=" + input);
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        response.close();  // You should close connections!

        return value;
    }


}
