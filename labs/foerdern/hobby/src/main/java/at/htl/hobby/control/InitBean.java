package at.htl.hobby.control;

import at.htl.hobby.entity.Hobby;
import at.htl.hobby.entity.Person;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class InitBean {

    @Inject
    PersonRepository personRepository;

    void startUp(@Observes StartupEvent event) {
        Person susi = new Person("Susi");
        Hobby lesen = new Hobby("Lesen");
        susi.setHobby(lesen);
        personRepository.save(susi);
        System.out.println(personRepository.findAll());
    }


}
