package pl.s2devs.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.s2devs.person.model.Courier;
import pl.s2devs.person.model.Person;

/**
 * Created by rafal on 01.12.17.
 */
@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {

    Courier findByPerson(Person person);
    Courier findByCourierId(Long id);

}
