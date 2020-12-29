package at.htl.hobby.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "H_HOBBY")
public class Hobby {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bezeichnung;

    @JsonbTransient
    @OneToMany
    private Map<String,Person> personen = new HashMap();

    public Hobby(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Hobby() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //region Getter and Setter
    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Map<String,Person> getPersonen() {
        return Collections.unmodifiableMap(personen);
    }

//    public void setPersonen(Set<Person> personen) {
//        this.personen = personen;
//    }
    //endregion

    public void addPerson(Person person) {
        personen.put(person.getName(),person);
    }

    public void deletePerson(Person person) {
        personen.remove(person.getName());
    }
}
