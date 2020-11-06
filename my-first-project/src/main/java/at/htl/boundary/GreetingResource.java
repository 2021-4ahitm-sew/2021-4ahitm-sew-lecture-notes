package at.htl.boundary;

import at.htl.control.GreetingService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("greet")
public class GreetingResource {
    
    @Inject
    GreetingService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}")
    public String greeting(@PathParam("name") String name) {
        return service.greeting(name);
    }
}
