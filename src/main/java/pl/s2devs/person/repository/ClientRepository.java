package pl.s2devs.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.s2devs.person.model.Client;
import pl.s2devs.person.model.Person;

/**
 * Created by rafal on 01.12.17.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByPerson(Person person);

}
