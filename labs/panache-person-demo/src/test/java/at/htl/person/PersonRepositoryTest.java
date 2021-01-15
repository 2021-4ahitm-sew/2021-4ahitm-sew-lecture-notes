package at.htl.person;

import at.htl.person.control.PersonRepository;
import at.htl.person.entity.Person;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PersonRepositoryTest {

    @Inject
    PersonRepository personRepository;

    @Test
    @Transactional
    void findById() {

        Person person = new Person(
                "Sandy",
                "Tang",
                LocalDate.of(2002,5,23)
        );

        personRepository.persist(person);

        Person sandy = personRepository.findById(1L);

        assertThat(sandy.getLastName()).isEqualTo("Tang");

    }
}
