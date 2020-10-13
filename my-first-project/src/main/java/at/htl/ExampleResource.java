package at.htl;

import at.htl.entity.Person;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
public class ExampleResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        var person = new Person();
        person.setName("Sepp");
        // for 200, other status codes can be used to fail test
        return Response.ok(person).build();
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

    @GET
    @Path("/response")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPersonResponse() {
        JsonObject marah = Json
                .createObjectBuilder()
                .add("name", "Marah")
                .add("dob", "2003-08-22")
                .build();
        
        Person jonas = new Person("Jonas der Beifahrer");

        //JsonObject j = Json.createReader().readObject()
        
        
        return Response
                .ok()
                .header("hip", "hop")
                .build();
    }

    private int counter;
    private String coolestStudent;

    @PUT
    @Path("cool")
    @Consumes(MediaType.APPLICATION_JSON)
    public String cool(Person person){
        this.coolestStudent = person.getName();
        return String.format("%s is cool", this.coolestStudent);
    }

    @POST
    @Path("jsontype")
    @Consumes(MediaType.APPLICATION_JSON)
    public String jsonType(JsonValue value){

        // Wenn OBJECT, dann gib das Objekt aus
        // wenn ARRAY, dann gib alle Elemente aus
        if (value.getValueType().equals(JsonValue.ValueType.OBJECT)){
            return value.toString();
        } else {
            String names ="";
            // iteriere durch das array
            for (JsonValue v : value.asJsonArray()) {
                names = names + "\n"
                        + v.asJsonObject().getString("vorname")
                        + " "
                        + v.asJsonObject().getString("nachname");
            }
            return names;
        }
    }

    @POST
    @Path("cnt")
    public int counter(){
        return ++counter;
    }

}