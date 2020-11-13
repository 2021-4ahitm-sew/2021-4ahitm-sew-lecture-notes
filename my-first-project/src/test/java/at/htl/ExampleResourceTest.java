package at.htl;

import at.htl.entity.Person;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class ExampleResourceTest {

    @Inject
    Logger LOG;

    /**
     * Es wird automatisch localhost:8080 verwendet
     * Alternative: .when().get("http://localhost:8080/person")
     * Specification ... techn. Beschreibung
     * validieren ... auf Gültigkeit überprüfen
     * verifizieren ... auf Korrektheit überprüfen
     */
    @Test
    public void testPersonEndpoint() {
        var person =
            // arrange
            given()
            // act
            .when().get("/person")
            // assert -> Rückgabe überprüfen
            .then()
                .statusCode(200)  // wir validieren
                .extract()
                .body()
                .as(Person.class);
        assertThat(person).isNotNull();
        assertThat(person.getName())
                .isNotNull()
                .isNotEmpty()
                .isEqualTo("Sepp");

        LOG.info(person);
    }

    @Test
    public void testPostPersonEndpoint() {

                given()
                        // arrange
                        .contentType(ContentType.JSON)
                        //.body("{\"vorname\": \"Markus\", \"nachname\": \"H\"}")
                        .body(  // Text Blocks
                        """
                        { 
                          "vorname":"Markus",
                          "nachname":"H"  
                        }
                        """)
                        // act
                        .when().post("/person/jsontype")
                        .then()
                        .statusCode(200);  // wir validieren
    }

}