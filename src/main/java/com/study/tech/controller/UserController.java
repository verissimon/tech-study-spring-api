package com.study.tech.controller;

import com.study.tech.dto.TechnologyDTO;
import com.study.tech.dto.UserDTO;
import com.study.tech.model.Technology;
import com.study.tech.model.User;
import com.study.tech.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok(service.listAll());
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        var newUser = service.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(location).body(newUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        var user = service.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/name/{username}")
    public ResponseEntity<UserDTO> findByUsername(@PathVariable String username) {
        var user = service.findByUsername(username);
        UserDTO respUser = new UserDTO();
        List<TechnologyDTO> techs = TechnologyDTO.buildTechDTO(user.getTechnologies());
        respUser.setUsername(user.getUsername());
        respUser.setId(user.getId());
        respUser.setTechnologies(techs);
        return ResponseEntity.ok(respUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(service.findById(id));
        return ResponseEntity.noContent().build();
    }
}
