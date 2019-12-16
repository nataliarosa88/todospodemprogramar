package br.com.todospodemprogramar.app.controller;

import br.com.todospodemprogramar.app.model.User;
import br.com.todospodemprogramar.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Natalia Rosa on 14/12/19.
 */
@Controller
@RequestMapping("/v2/users")
public class RestController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveMyUser(user));
    }

    @PutMapping(path = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int id) {
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

}
