package pl.s2devs.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.s2devs.person.model.Client;
import pl.s2devs.person.service.ClientService;
import pl.s2devs.shared.response.person.RegistrationResponse;

import static pl.s2devs.shared.response.person.RegistrationResponse.*;

/**
 * Created by rafal on 01.12.17.
 */
@RestController
@RequestMapping("/user/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<RegistrationResponse<Client>> newClient(@RequestParam Long personId) {
        return ResponseEntity.ok(
                new RegistrationResponse<>(clientService.registerClient(personId), Code.REGISTERED)
        );
    }

}
