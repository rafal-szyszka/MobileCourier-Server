package pl.s2devs.person.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by rafal on 01.12.17.
 */
@Entity
public class Courier {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courierId;

    @NotNull
    private String licence;
    @NotNull
    private String carLicence;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "person_id")
    private Person person;

    public Long getCourierId() {
        return courierId;
    }

    public void setCourierId(Long courierId) {
        this.courierId = courierId;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getCarLicence() {
        return carLicence;
    }

    public void setCarLicence(String carLicence) {
        this.carLicence = carLicence;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
