package at.htl.person.boundary;

import at.htl.person.control.PersonRepository;
import at.htl.person.entity.Person;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/person")
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> findAll() {
        return personRepository
                .findAll()
                .list();
    }

}
