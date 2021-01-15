package at.htl.person.control;

import at.htl.person.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    public Person findByLastName(String lastName) {
        return find("lastName", lastName).firstResult();
    }

}
