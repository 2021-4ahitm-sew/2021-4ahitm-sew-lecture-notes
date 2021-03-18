package at.htl;

import javax.json.Json;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class GreetingResource {

    /**
     * https://javaee.github.io/jsonp/
     * @return json array of persons
     */
    @Path("people")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray hello() {
        //String[] persons = new String[] {"Adam", "Eve", "Snake"};

        return Json.createArrayBuilder()
                .add(Json.createObjectBuilder().add("name", "Adam"))
                .add(Json.createObjectBuilder().add("name", "Eve"))
                .add(Json.createObjectBuilder().add("name", "Steve"))
                .build();
    }
}