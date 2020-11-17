package at.htl.control;

import at.htl.entity.Gender;
import at.htl.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PersonRepository {

    @Inject
    EntityManager em;

    public void add(Person newPerson) {
        em.persist(newPerson);
    }

    public Person getById(Long id){
        var query = em.createQuery("select p from Person p where p.id = :id", Person.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    public List<Person> getByGender(Gender gender){
        var q = em.createNamedQuery("Person.getByGender", Person.class);
        q.setParameter("gender", gender);
        return q.getResultList();
    }

}
