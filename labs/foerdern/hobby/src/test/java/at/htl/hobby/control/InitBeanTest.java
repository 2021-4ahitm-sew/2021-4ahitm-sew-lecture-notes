package at.htl.hobby.control;

import at.htl.hobby.entity.Hobby;
import at.htl.hobby.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InitBeanTest {

    @BeforeEach
    public void init() {
    }

    @Test
    void t001() {
        Hobby lesen = new Hobby("Lesen");
        Hobby bingen = new Hobby("Bingen");
        Hobby gamblen = new Hobby("1x Playstation");
        Person susi = new Person("Susi");
        susi.setHobby(lesen);
        //lesen.addPerson(susi);

        System.out.println(susi.getHobby().getBezeichnung());
        System.out.println(lesen.getPersonen().get("Susi").getName());

        System.out.println("");
        assertThat(lesen.getPersonen().size()).isEqualTo(1);
    }
}
