package at.htl.control;

import at.htl.entity.Person;
import at.htl.entity.Sex;

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

    public List<Person> getBySex(Sex sex){
        var q = this.em.createNamedQuery("getBySex", Person.class);
        q.setParameter("sex", sex);
        return q.getResultList();
    }
}
