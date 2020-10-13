package at.htl;

import at.htl.entity.Person;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class ExampleResourceTest {

    @Test
    public void testPersonEndpoint() {
        var person = given()
                .when().get("/person")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(Person.class);
        assertThat(person).isNotNull();
        assertThat(person.getName())
                .isNotNull().isNotEmpty()
                .isEqualTo("Sepp");
    }

}