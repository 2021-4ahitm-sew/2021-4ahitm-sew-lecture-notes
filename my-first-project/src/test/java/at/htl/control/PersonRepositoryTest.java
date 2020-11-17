package at.htl.control;

import at.htl.entity.Person;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;
import org.postgresql.ds.PGSimpleDataSource;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.transaction.*;

import java.time.LocalDate;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;

@QuarkusTest
class PersonRepositoryTest {

    @Inject
    EntityManager em;

    @Inject
    PersonRepository repo;

    @Inject
    UserTransaction tx;
    @Test
    //@Transactional
    void insertPerson() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        Person susi = new Person("Susi");
        tx.begin();
        repo.add(susi);
        tx.commit();

        Table personTable = new Table(getDataSource(), "person");
        output(personTable).toConsole();
        org.assertj.db.api.Assertions.assertThat(personTable).hasNumberOfRows(1);
    }

    @Transactional
    @Test
    void retrievePerson() {
        Person hansi = new Person("Hansi");
        repo.add(hansi);
        var q = em.createQuery("select p from Person p where p.name = 'Hansi'", Person.class);
        System.out.println(q.getResultList().stream().findFirst());
    }

    static final String DATABASE = "quarkdb";
    static final String USERNAME = "postgres";
    static final String PASSWORD = "postgres";
    public static final String URL = "jdbc:postgresql://localhost:5432/quarkdb";

    public static DataSource getDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName(DATABASE);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
}