package pl.s2devs.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.s2devs.person.model.Client;
import pl.s2devs.person.model.Person;
import pl.s2devs.person.repository.ClientRepository;
import pl.s2devs.person.repository.PersonRepository;

/**
 * Created by rafal on 01.12.17.
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PersonRepository personRepository;

    public Client registerClient(Long personId) {
        Person person = personRepository.findByPersonId(personId);
        Client client = clientRepository.findByPerson(person);

        if(isAlreadyClient(client)) {
            return client;
        } else {
            client = new Client();
            client.setPerson(person);
            clientRepository.save(client);
            return client;
        }
    }

    private boolean isAlreadyClient(Client client) {
        return client != null;
    }

}
