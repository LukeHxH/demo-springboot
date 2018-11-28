package com.example.lukehxh.demo.endpoint;

import com.example.lukehxh.demo.exceptions.PersonNotFound;
import com.example.lukehxh.demo.model.Person;
import com.example.lukehxh.demo.repository.PersonRepository;
import com.example.lukehxh.demo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("person")
public class PersonEndpoint {

    private final DateUtil dateUtil;
    private final PersonRepository personDAO;

    @Autowired
    public PersonEndpoint(DateUtil dateUtil, PersonRepository personDAO) {
        this.dateUtil = dateUtil; // testing with date
        this.personDAO = personDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(this.personDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable("id") Long id) {
        Optional<Person> personOptional = this.personDAO.findById(id);
        Person person = null;

        if (personOptional.isPresent())
            person = personOptional.get();

        return (person == null) ? new ResponseEntity<>(new PersonNotFound(), HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Person person) {
        return new ResponseEntity<>(this.personDAO.save(person), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestBody Person person) {
        this.personDAO.delete(person);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Person person) {
        this.personDAO.save(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/data")
    public String dateAccess(){
        return dateUtil.formateLocalDateTimeToDatabaseStyle(LocalDateTime.now());
    }
}
