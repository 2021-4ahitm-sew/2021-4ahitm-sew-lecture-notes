package at.htl.boundary;

import at.htl.control.PersonService;
import at.htl.entity.Person;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("person")
public class PersonResource {

    @Inject
    PersonService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Long add(Person personDTO){
        var person = this.service.addPerson(personDTO);
        return person.getId();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") Long personId){
        var person = this.service.getPersonById(personId);
        if (person == null){
            return Response.status(404).build();
        }
        return Response.ok(person).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("female")
    public Response getAllFemales(){
        var people = this.service.getAllFemales();
        return Response.ok(people).build();
    }

}
