package com.files_and_folders.files_and_folders.controllers;

import com.files_and_folders.files_and_folders.models.File;
import com.files_and_folders.files_and_folders.models.Person;
import com.files_and_folders.files_and_folders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping(value = "/people")
    public ResponseEntity<List<Person>> getAllPeople(){
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/people/{id}")
    public ResponseEntity getPerson(@PathVariable Long id){
        return new ResponseEntity(personRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/people")
    public ResponseEntity<Person> postPerson(@RequestBody Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
