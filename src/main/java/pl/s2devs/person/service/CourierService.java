package pl.s2devs.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.s2devs.person.model.Courier;
import pl.s2devs.person.model.CourierRegistrationData;
import pl.s2devs.person.model.Person;
import pl.s2devs.person.repository.CourierRepository;
import pl.s2devs.person.repository.PersonRepository;

/**
 * Created by rafal on 01.12.17.
 */
@Service
public class CourierService {

    @Autowired
    private CourierRepository courierRepository;
    @Autowired
    private PersonRepository personRepository;

    public Courier registerNewCourier(Long personId, CourierRegistrationData data) {
        Person person = personRepository.findByPersonId(personId);
        Courier courier = courierRepository.findByPerson(person);

        if(isAlreadyCourier(courier)) {
            return courier;
        } else {
            courier = new Courier();
            courier.setPerson(person);
            courier.setCarLicence(data.getCarLicence());
            courier.setLicence(data.getLicence());

            courierRepository.save(courier);

            return courier;
        }
    }

    private boolean isAlreadyCourier(Courier courier) {
        return courier != null;
    }


}
