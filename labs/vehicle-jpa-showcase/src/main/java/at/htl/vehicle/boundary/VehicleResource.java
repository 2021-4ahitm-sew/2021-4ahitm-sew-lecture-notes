package at.htl.vehicle.boundary;

import at.htl.vehicle.control.VehicleRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("vehicle")
public class VehicleResource {

    @Inject
    VehicleRepository vehicleRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(vehicleRepository.findAll()).build();
    }

}
