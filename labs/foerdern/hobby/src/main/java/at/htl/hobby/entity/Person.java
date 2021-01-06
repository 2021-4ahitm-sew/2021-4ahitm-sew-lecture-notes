package at.htl.hobby.entity;

import javax.persistence.*;

@Entity
@Table(name = "H_PERSON")
@NamedQueries({
        @NamedQuery(
                name = "Person.findAll",
                query = "select p from Person p order by p.name"
        )
})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    //(cascade = CascadeType.ALL)  ... zu gefährlich
    private Hobby hobby;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby newHobby) {
        // wenn bereits ein Hobby vorhanden, dann lösche diese Person aus vorherigem Hobby
        if (this.hobby != null) {
            this.hobby.deletePerson(this);
        }

        // nur wenn ein neues Hobby eingetragen wird,
        // kann man die Person im Hobby-Objekt eintragen.
        // (ansonsten NPE - -NullPointerException)
        if (newHobby != null) {
            // trage diese Person in das übergebene Hobby ein
            newHobby.addPerson(this);
        }

        this.hobby = newHobby;
    }

    @Override
    public String toString() {
        return String.format("%d: %s", id, name);
    }
}
