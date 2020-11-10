package at.htl.boundary;

import at.htl.control.PersonService;
import at.htl.entity.Person;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("person")
public class PersonResource {
    @Inject
    PersonService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public int add(Person personDTO){
        var person = this.service.addPerson(personDTO.getName());
        return person.getId();
    }
}
