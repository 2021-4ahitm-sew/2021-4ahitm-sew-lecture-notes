package at.htl.control;

import at.htl.entity.Hobby;
import at.htl.entity.Person;
import at.htl.entity.Sex;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonService {

    @Inject
    PersonRepository repository;
    @Inject
    private Logger logger;

    @Transactional
    public Person addPerson(Person personDTO){
        var newPerson = new Person(personDTO.getName()); // gibt es in Java mittlerweile so etwas wie einen Object Initializer?
        newPerson.setSex(personDTO.getSex());
        newPerson.setDayOfBirth(personDTO.getDayOfBirth());

        var hobbies = new ArrayList<Hobby>();
        for(var hobbyDTO : personDTO.getHobbies()){
            var newHobby = new Hobby();
            newHobby.setName(hobbyDTO.getName());
            newHobby.setCategory(hobbyDTO.getCategory());
            newHobby.setPerson(newPerson);
            hobbies.add(newHobby);
        }
        newPerson.setHobbies(hobbies);

        repository.add(newPerson);
        return newPerson;
    }

    @Transactional
    public Person getPersonById(Long id) {
        var person = this.repository.getById(id);
        logger.log(Logger.Level.DEBUG,
                "Retrived person, hobbies not yet loaded (no join) - break here to check");
        return person;
    }

    @Transactional
    public List<Person> getAllFemales(){
        return this.repository.getBySex(Sex.FEMALE);
    }
}
