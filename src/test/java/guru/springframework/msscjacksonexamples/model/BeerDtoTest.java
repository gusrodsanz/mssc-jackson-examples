package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;


@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;


    @Test
    void testSerializeDto() throws JsonProcessingException {

        BeerDto beerDto = getDto();
        String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println( jsonString );
    }

    @Test
    void testDeserialize() throws IOException {
        String jsonString = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":\"12.99\",\"createdDate\":\"2020-11-21T17:33:50+0100\",\"lastUpdatedDate\":\"2020-11-21T17:33:50.220082+01:00\",\"myLocalDate\":\"20201121\",\"beerId\":\"732977fe-8d74-4d34-a789-750899ef8b9d\"}\n";

        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);
        System.out.println( beerDto );
    }
}