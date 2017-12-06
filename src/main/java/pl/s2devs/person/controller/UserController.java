package pl.s2devs.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.s2devs.person.model.Person;
import pl.s2devs.person.service.PersonService;
import pl.s2devs.shared.response.person.RegistrationResponse;
import pl.s2devs.shared.response.person.UpdateResponse;

import java.util.List;

/**
 * Created by rafal on 14.11.17.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public ResponseEntity<List<Person>> getAllClients() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping(value = "/", params = "email")
    public ResponseEntity<Person> getClientByEmail(@RequestParam String email) {
        return ResponseEntity.ok(personService.findByEmail(email));
    }

    @GetMapping(value = "/", params = "id")
    public ResponseEntity<Person> getClientById(@RequestParam Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @PutMapping("/")
    public ResponseEntity<UpdateResponse<Person>> getClientById(@RequestBody Person person) {
        return ResponseEntity.ok(
                new UpdateResponse<>(person, personService.updatePerson(person))
        );
    }

    @PostMapping("/new")
    public ResponseEntity<RegistrationResponse<Person>> registerNewPerson(@RequestBody Person person) {
        return ResponseEntity.ok(new RegistrationResponse(
                person,
                personService.registerNewPerson(person)
        ));
    }

    @PostMapping("/new/all")
    public ResponseEntity<RegistrationResponse<List<Person>>> registerAllPeople(@RequestBody List<Person> people) {
        return ResponseEntity.ok(new RegistrationResponse(
                people,
                personService.registerAllPeople(people)
        ));
    }
}
