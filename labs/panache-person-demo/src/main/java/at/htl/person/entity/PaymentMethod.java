package at.htl.person.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SC_PAYMENT_METHOD")
public class PaymentMethod {

    @Id
    private String abbr;  // EINZ, AUSZ, ZINS
    private String name;

    public PaymentMethod() {
    }

    public PaymentMethod(String abbr, String name) {
        this.abbr = abbr;
        this.name = name;
    }

    //region getter and setter
    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion


    @Override
    public String toString() {
        return String.format("%s (%s)", abbr, name);
    }
}
