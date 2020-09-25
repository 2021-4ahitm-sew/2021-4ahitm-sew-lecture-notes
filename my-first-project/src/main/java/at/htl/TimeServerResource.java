package at.htl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;

@Path("/time")
@Produces(MediaType.TEXT_PLAIN)
public class TimeServerResource {
    @GET
    public String time() {
        return "Time: " + LocalDateTime.now();
    }
}