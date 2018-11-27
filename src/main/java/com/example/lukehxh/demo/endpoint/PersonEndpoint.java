package com.example.lukehxh.demo.endpoint;

import com.example.lukehxh.demo.exceptions.PersonNotFound;
import com.example.lukehxh.demo.model.Person;
import com.example.lukehxh.demo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("person")
public class PersonEndpoint {

    private final DateUtil dateUtil;

    @Autowired
    public PersonEndpoint(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(Person.getPersonList(),
                HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable("id") int id) {

        Person person = new Person();
        person.setId(id);

        int index = Person.getPersonList().indexOf(person);

        if (index == -1) {
            return new ResponseEntity<>(new PersonNotFound(),
                    HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(Person.getPersonList().get(index), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Person person) {
        Person.getPersonList().add(person);

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Person person) {
        Person.getPersonList().remove(person);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Person person) {
        Person.getPersonList().remove(person);
        Person.getPersonList().add(person);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/data")
    public String dateAccess(){
        return dateUtil.formateLocalDateTimeToDatabaseStyle(LocalDateTime.now());
    }
}
