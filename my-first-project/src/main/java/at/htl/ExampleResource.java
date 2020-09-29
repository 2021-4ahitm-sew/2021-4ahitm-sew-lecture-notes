package at.htl;

import at.htl.entity.Person;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class ExampleResource {

    @GET
    @Produces({
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_JSON,
            MediaType.TEXT_PLAIN
    })
    public Person hello() {
        return new Person("dorfelmännchen");
    }

    @GET
    @Path("/zk")
    @Produces("text/plain")
    public String findPersonString() {
        return new Person("apfelmännchen").toString();
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject findPersonJson() {
        return Json
                .createObjectBuilder()
                .add("name", "Marah")
                .add("dob", "2003-08-22")
                .build();
    }


}