package ws.client;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import ws.client.model.Data;
import ws.client.model.Output;
import ws.client.model.Translation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GoogleTranslateTest {

    final String key = "AIzaSyBde9PPInnRvdcwiMzie1AQLvdxdVZdvoY";

    @Test
    public void should_translate_with_google() {
        final String input = "Hi my name is John";
        final String output = "Cześć, nazywam się John";

        GoogleTranslate t = new GoogleTranslate(key);
        assertThat(t.translationFor(input), equalTo(output));
    }

    @Test
    public void aaa() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Output output = new Output();
        Data d = new Data();


        List<Translation> tl = new ArrayList<Translation>();
        Translation t = new Translation();
        t.setTranslatedText("Dsdsds");

        tl.add(t);
        d.setTranslations(tl);
        output.setData(d);

        System.out.println(mapper.writeValueAsString(output));

    }

}