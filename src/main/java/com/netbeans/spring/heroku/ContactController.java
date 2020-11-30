/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netbeans.spring.heroku;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author UI600212
 */
@CrossOrigin(origins = "*")
@RestController
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    /**
     *
     * @return
     */
    @GetMapping(value = "/")
    public ResponseEntity index() {
        return ResponseEntity.ok(contactRepository.findAll());
    }
    
    @GetMapping(value = "/contact")
    public ResponseEntity getBucket(@RequestParam(value = "id") Long id) {
        Optional<Contact> foundContact = contactRepository.findById(id);

        if (foundContact.isPresent()) {
            return ResponseEntity.ok(foundContact.get());
        } else {
            return ResponseEntity.badRequest().body("No contact with specified id " + id + " found");
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity addToContact(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email, @RequestParam(value = "phone") String phone) {
        return ResponseEntity.ok(contactRepository.save(new Contact(name, email, phone)));
    }

    @PutMapping(value = "/")
    public ResponseEntity updateContact(@RequestParam(value = "name") String name, @RequestParam(value = "id") Long id, @RequestParam(value = "email") String email, @RequestParam(value = "phone") String phone) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (!optionalContact.isPresent()) {
            return ResponseEntity.badRequest().body("No contact with specified id " + id + " found");
        }

        Contact foundContact = optionalContact.get();
        foundContact.setName(name);
        foundContact.setEmail(email);
        foundContact.setPhone(phone);

        return ResponseEntity.ok(contactRepository.save(foundContact));
    }

    @DeleteMapping(value = "/")
    public ResponseEntity removeContact(@RequestParam(value = "id") Long id) {
        contactRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
