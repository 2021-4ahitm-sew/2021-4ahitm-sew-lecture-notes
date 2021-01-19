package at.htl.person;

import at.htl.person.control.PersonRepository;
import at.htl.person.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PersonRepositoryTest {

    @Inject
    PersonRepository personRepository;

    @Test
    @Transactional
    void t010_findById() {

        Person person = new Person(
                "Sandy",
                "Tang",
                LocalDate.of(2002, 5, 23)
        );

        System.out.printf("Id der Person ist %d\n", person.getId());

        personRepository.persist(person);

        System.out.printf("Id der Person ist %d", person.getId());
        Person sandy = personRepository.findById(person.getId());

        assertThat(sandy.getLastName()).isEqualTo("Tang");

        person.setFirstName("Sandy Lisa");
    }


    @Test
    void t020_findByLastName() {
        //Person p = personRepository.findByLastName("Duck");
        List<Person> persons = personRepository.find("lastName", Sort.by("firstName"), "Duck").list();
        System.out.println(persons);

        // assertThat missing
    }


    @Test
    void t030_paging() {
        //Person p = personRepository.findByLastName("Duck");
        //PanacheQuery<Person> persons =  personRepository.find("lastName", Sort.by("firstName"), "Duck");
        //System.out.println(persons);
        generatePersons();
        int pageSize = 10;

        System.out.println(personRepository.count("lastName", "Dorfel"));

        PanacheQuery<Person> persons = personRepository.find("lastName", "Dorfel");
        persons.page(Page.ofSize(pageSize));
        while (persons.hasNextPage()) {
            System.out.println(persons.nextPage().list());
            System.out.println("=========================================");
        }

    }

    @Transactional
    void generatePersons() {
        personRepository.deleteAll();
        String[] lastNames = {"Wiesinger", "Dorfel", "Schollinger"};
        String[] firstNames = {"Jonas", "Rosie", "Isabell", "Felix", "Lukas"};

        for (int i = 0; i < 1000; i++) {
            Random rnd = new Random();
            int lnno = rnd.nextInt(lastNames.length);
            int fnno = rnd.nextInt(firstNames.length);
            Person p = new Person(firstNames[fnno], lastNames[lnno]);
            personRepository.persist(p);
        }
    }

}
