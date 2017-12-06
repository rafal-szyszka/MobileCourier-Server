package pl.s2devs.person.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by rafal on 01.12.17.
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "person_id")
    private Person person;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
