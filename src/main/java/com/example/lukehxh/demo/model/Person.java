package com.example.lukehxh.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Person {

    private int id;
    private String name;
    private static List<Person> personList;

    static {
        personRepository();
    }

    public Person() { }

    public Person(int id, String name) {
        this(name);
        this.id = id;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static List<Person> getPersonList() {
        return personList;
    }

    private static void personRepository() {
        personList = new ArrayList<>(Arrays.asList(new Person(1,"Aderbaldo"),
                new Person(2,"Lucas"),
                new Person("Gordon Freeman")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
