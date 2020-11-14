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

    public Person getById(Long id) {
        var q = this.em.createQuery("select p from Person p where p.id = :id", Person.class);
        q.setParameter("id", id);
        return q.getResultList().stream().findFirst().orElse(null);
    }

    public List<Person> getByGender(Gender gender){
        var q = this.em.createNamedQuery("getByGender", Person.class);
        q.setParameter("gender", gender);
        return q.getResultList();
    }
}
