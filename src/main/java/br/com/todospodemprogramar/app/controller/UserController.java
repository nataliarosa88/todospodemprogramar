package br.com.todospodemprogramar.app.controller;

import br.com.todospodemprogramar.app.adapter.UserAdapter;
import br.com.todospodemprogramar.app.dto.UserDTO;
import br.com.todospodemprogramar.app.exception.ServiceException;
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
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) throws ServiceException {
        return ResponseEntity.ok(UserAdapter.toUserDTO(userService.save(UserAdapter.toUser(userDTO))));
    }

    @PutMapping(path = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable int id) throws ServiceException {
        userDTO.setId(id);
        UserDTO dto = UserAdapter.toUserDTO(userService.save(UserAdapter.toUser(userDTO)));
        return ResponseEntity.ok(dto);
    }

}
