package at.htl.person.control;

import at.htl.person.entity.PaymentMethod;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;


import static org.assertj.db.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentMethodRepositoryTest {

    @Inject
    PaymentMethodRepository paymentMethodRepository;

    @Inject
    AgroalDataSource source;

    @Test
    void t010_createPaymentMethod() {
        PaymentMethod pm = new PaymentMethod("EINZ", "Einzahlung");
        pm = paymentMethodRepository.save(pm);

        Table table = new Table(source, "SC_PAYMENT_METHOD");
        output(table).toConsole();
        assertThat(table)
                .row(0)
                .value("ABBR").isEqualTo("EINZ")
                .value("NAME").isEqualTo("Einzahlung");
    }
}
