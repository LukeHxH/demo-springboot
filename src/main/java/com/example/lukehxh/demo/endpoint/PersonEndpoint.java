package com.example.lukehxh.demo.endpoint;

import com.example.lukehxh.demo.exceptions.PersonNotFound;
import com.example.lukehxh.demo.model.Person;
import com.example.lukehxh.demo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("person")
public class PersonEndpoint {

    private final DateUtil dateUtil;

    @Autowired
    public PersonEndpoint(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(Person.getPersonList(),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
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

    @RequestMapping(method = RequestMethod.GET, path = "/data")
    public String dateAccess(){
        return dateUtil.formateLocalDateTimeToDatabaseStyle(LocalDateTime.now());
    }
}
