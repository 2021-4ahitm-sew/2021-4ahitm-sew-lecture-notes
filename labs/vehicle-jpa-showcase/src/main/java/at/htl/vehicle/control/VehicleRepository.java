package at.htl.vehicle.control;

import at.htl.vehicle.entity.Vehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class VehicleRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Vehicle save(Vehicle vehicle) {
        return em.merge(vehicle);
    }

    public Vehicle findById(long id) {
        return em.find(Vehicle.class, id);
    }

    public List<Vehicle> findAll() {
        return em
                .createNamedQuery("Vehicle.findAll",Vehicle.class)
                .getResultList();
    }

}
