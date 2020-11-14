package at.htl.control;

import at.htl.entity.Gender;
import at.htl.entity.Hobby;
import at.htl.entity.HobbyCategory;
import at.htl.entity.Person;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class PersonRepositoryTest {

    @Inject
    EntityManager em;

    @Inject
    PersonRepository repo;

    @Test
    @Transactional
    void insertPerson(){
        Person susi = new Person("Susi");
        repo.add(susi);
    }

    @Transactional
    @Test
    void retrievePerson() {
        Person hansi = new Person("Hansi");
        repo.add(hansi);
        var q = em.createQuery("select p from Person p where p.name = 'Hansi'", Person.class);
        System.out.println(q.getResultList().stream().findFirst());
    }

    @Transactional
    @Test
    void retrievePersonById() {
        var hobby = new Hobby();
        hobby.setName("Fischen");
        hobby.setCategory(HobbyCategory.OUTDOOR);
        Person hansi = new Person("Hansi");
        hansi.setHobbies(Collections.singletonList(hobby));
        hansi.setDayOfBirth(LocalDate.of(2010, 10, 10));
        repo.add(hansi);

        var retrievedPerson = repo.getById(hansi.getId());
        assertThat(retrievedPerson)
                .isNotNull();
        assertThat(retrievedPerson.getHobbies())
                .isNotNull()
                .isNotEmpty();
        assertThat(retrievedPerson)
                .usingRecursiveComparison()
                .isEqualTo(hansi);
    }

    @Transactional
    @Test
    void retrievePeopleByGender(){
        var hobby = new Hobby();
        hobby.setName("Fischen");
        hobby.setCategory(HobbyCategory.OUTDOOR);
        Person hansi = new Person("Hansi");
        hansi.setHobbies(Collections.singletonList(hobby));
        hansi.setDayOfBirth(LocalDate.of(2010, 10, 10));
        hansi.setGender(Gender.MALE);
        Person susi = new Person("Susi");
        susi.setHobbies(Collections.singletonList(hobby));
        susi.setDayOfBirth(LocalDate.of(2011, 10, 10));
        susi.setGender(Gender.FEMALE);
        repo.add(hansi);
        repo.add(susi);

        var people = repo.getByGender(Gender.FEMALE);
        assertThat(people)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);
        assertThat(people.get(0))
                .usingRecursiveComparison()
                .isEqualTo(susi);
    }
}