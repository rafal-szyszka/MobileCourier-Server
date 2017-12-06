package pl.s2devs.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.s2devs.person.model.Person;
import pl.s2devs.person.repository.PersonRepository;
import pl.s2devs.shared.response.person.UpdateResponse;

import java.util.List;
import java.util.stream.Collectors;

import static pl.s2devs.shared.response.person.RegistrationResponse.Code;

/**
 * Created by rafal on 14.11.17.
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Code registerNewPerson(Person person) {
        Person nullable = personRepository.findByEmail(person.getEmail());

        if(emailAddressIsAvailable(nullable)) {
            personRepository.save(person);
            return Code.REGISTERED;
        } else {
            return Code.EMAIL_TAKEN;
        }

    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    public Person findById(Long id) {
        return personRepository.findByPersonId(id);
    }

    public Boolean updatePerson(Person person) {
        if(idSpecified(person.getPersonId())) {
            personRepository.save(person);
            return UpdateResponse.UPDATED;
        } else {
            return UpdateResponse.FAILED_TO_UPDATE;
        }
    }

    private boolean emailAddressIsAvailable(Person nullable) {
        return nullable == null;
    }

    private boolean idSpecified(Long personId) {
        return personId != null;
    }

    public Code registerAllPeople(List<Person> people) {
        List<Person> peopleWithAvailableEmails = people.stream()
                .filter(person -> personEmailIsAlreadyTaken(person.getEmail()))
                .collect(Collectors.toList());

        peopleWithAvailableEmails.forEach(
                person -> personRepository.save(person)
        );

        return Code.REGISTERED;
    }

    private boolean personEmailIsAlreadyTaken(String email) {
        return personRepository.findByEmail(email) == null;
    }
}
