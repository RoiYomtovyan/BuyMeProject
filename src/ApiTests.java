
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiTests {


    @Test
    public void
    simple_given_when_then_works() {
        given().
                pathParam("city","london").
                when().
                get("http://api.weatherapi.com/v1/current.json?key=ddbdc26e557b43c09b853941232206&q={city}&aqi=no").
                then().
                statusCode(200).
                body("location.name", equalTo("London")).
                body("location.country", equalTo("United Kingdom"));
    }

}
