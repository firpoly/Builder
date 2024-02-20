package org.example;

import java.util.Optional;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {

        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;

    }

    public boolean hasAge() {
        OptionalInt optional = getAge();
        return optional.isPresent();
    }

    public boolean hasAddress() {
        return this.address.isEmpty();
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        OptionalInt age = OptionalInt.of(this.age);
        if (age.isPresent() && age.getAsInt() != 0) {
            return age;
        } else {
            return age.empty();
        }
    }

    public String getAddress() {
        return hasAddress() ? this.address : "";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age++;
    }

    public PersonBuilder newChildBuilder() {
        var person = new PersonBuilder();
        person.setSurname(this.getSurname());
        return person;
    }

    @Override
    public String toString() {
        return getName();
    }

}


