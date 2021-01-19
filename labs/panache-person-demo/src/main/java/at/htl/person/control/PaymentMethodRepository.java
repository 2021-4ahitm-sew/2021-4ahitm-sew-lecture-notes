package at.htl.person.control;

import at.htl.person.entity.PaymentMethod;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

@ApplicationScoped
public class PaymentMethodRepository implements PanacheRepositoryBase<PaymentMethod, String> {

    /**
     * create a new record, if id doesn't exist in db table
     * updates a record, if id exists in db table
     * 
     * @param pm
     * @return a attached object of type PaymentMethod
     */
    @Transactional
    public PaymentMethod save(PaymentMethod pm) {
        return getEntityManager().merge(pm);
    }


}
