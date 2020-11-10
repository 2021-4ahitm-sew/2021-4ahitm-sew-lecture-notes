package at.htl.control;

import at.htl.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class PersonService {
    @Inject
    EntityManager em;

    @Transactional
    public Person addPerson(String name){
        var newPerson = new Person(name);
        em.persist(newPerson);
        return newPerson;
    }
}
