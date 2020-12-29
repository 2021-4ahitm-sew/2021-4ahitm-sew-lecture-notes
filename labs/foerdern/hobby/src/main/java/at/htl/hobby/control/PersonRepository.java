package at.htl.hobby.control;

import at.htl.hobby.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PersonRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Person save(Person person) {
        return em.merge(person);
    }

    public List<Person> findAll() {
        List<Person> personList = em
                .createNamedQuery("Person.findAll",Person.class)
                .getResultList();
        return personList;
    }


}
