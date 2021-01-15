package at.htl.person.control;

import at.htl.person.entity.Person;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;

@ApplicationScoped
public class InitBean {
    
    @Inject
    PersonRepository personRepository;

    @Transactional
    void onStartup(@Observes StartupEvent event) {
        System.out.println("It works!");
        personRepository.persist(new Person("Donald","Duck", LocalDate.of(1930,6,01)));
        personRepository.persist(new Person("Dagobert","Duck", LocalDate.of(1936,1,16)));
        personRepository.persist(new Person("Dorette","Duck", LocalDate.of(1942,8,31)));
        personRepository.persist(new Person("Kater","Karlo", LocalDate.of(1937,12,3)));
    }

}
