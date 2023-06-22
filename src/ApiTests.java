
import com.google.gson.JsonObject;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiTests {

    String filePath = "C:\\Users\\avivit\\Documents\\GitHub\\BuyMeProject\\config.json";

    JSONObject config = jsonReader.parseJSONFile(filePath);

    String url = config.getJSONObject("api").get("url").toString();
    String urlSuffix = config.getJSONObject("api").get("urlSuffix").toString();
    String city = "london";


    public ApiTests() throws IOException {
    }


    @Test
    public void
    simple_given_when_then_works() {
        given().
                pathParam("city","london").
                when().
                get(url + "{city}" + urlSuffix).
                then().assertThat().statusCode(200).
                body("location.name", equalTo("London")).
                body("location.country", equalTo("United Kingdom"));
    }

}
