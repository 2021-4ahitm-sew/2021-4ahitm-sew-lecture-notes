package at.htl.vehicle.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class VehicleResourceTest {

    @Karate.Test
    Karate t200_createBooking() {
        return Karate.run("vehicle-get").relativeTo(getClass());
    }



}
