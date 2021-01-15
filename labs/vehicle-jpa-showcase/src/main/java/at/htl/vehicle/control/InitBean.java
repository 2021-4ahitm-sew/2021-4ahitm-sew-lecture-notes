package at.htl.vehicle.control;

import at.htl.vehicle.entity.Vehicle;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @Inject
    VehicleRepository vehicleRepository;

    @Transactional
    void onStart(@Observes StartupEvent event) {
        vehicleRepository.save(new Vehicle("Ford", "Mustang"));
        vehicleRepository.save(new Vehicle("Ford", "Ram"));
    }
}
