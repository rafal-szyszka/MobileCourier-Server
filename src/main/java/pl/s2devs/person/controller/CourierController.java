package pl.s2devs.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.s2devs.person.model.Courier;
import pl.s2devs.person.model.CourierRegistrationData;
import pl.s2devs.person.service.CourierService;
import pl.s2devs.shared.response.person.RegistrationResponse;

import static pl.s2devs.shared.response.person.RegistrationResponse.*;

/**
 * Created by rafal on 01.12.17.
 */

@RestController
@RequestMapping("/user/courier")
public class CourierController {

    @Autowired
    private CourierService courierService;

    @PostMapping
    public ResponseEntity<RegistrationResponse<Courier>> newCourier(
            @RequestParam Long personId,
            @RequestBody CourierRegistrationData data) {

        return ResponseEntity.ok(
                new RegistrationResponse<>(courierService.registerNewCourier(personId, data), Code.REGISTERED)
        );
    }

}