package com.codegym.controller;

import com.codegym.model.Role;
import com.codegym.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @GetMapping
    public ResponseEntity<Iterable<Role>> findAllRole() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable Long id) {
        Optional<Role> role = roleService.findById(id);
        return role.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.save(role), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateCustomer(@PathVariable Long id, @RequestBody Role role) {
        Optional<Role> roleOptional = roleService.findById(id);
        if (!roleOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            role.setId(roleOptional.get().getId());
            return new ResponseEntity<>(roleService.save(role), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Role> deleteCustomer(@PathVariable Long id) {
        Optional<Role> roleOptional = roleService.findById(id);
        if (!roleOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        roleService.remove(id);
        return new ResponseEntity<>(roleOptional.get(), HttpStatus.OK);
    }

}
