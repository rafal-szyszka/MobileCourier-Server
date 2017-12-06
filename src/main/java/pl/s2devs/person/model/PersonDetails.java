package pl.s2devs.person.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by rafal on 29.11.17.
 */
@Entity
public class PersonDetails {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personDetailsId;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "address_id")
    private Address address;

    public Long getPersonDetailsId() {
        return personDetailsId;
    }

    public void setPersonDetailsId(Long personDetailsId) {
        this.personDetailsId = personDetailsId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
