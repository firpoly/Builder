package org.example;

import java.util.Optional;


public class PersonBuilder {
    public String name;
    public String surname;
    public int age;
    public String address;
    public Optional optinalName, optinalSurname;

    public PersonBuilder() {
        optinalName = Optional.empty();
        optinalSurname = Optional.empty();
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        optinalName = Optional.of(name);
        return this;
    }

    public boolean haveInfo() {

        return optinalSurname.isEmpty() && optinalName.isEmpty();
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        optinalSurname = Optional.of(surname);
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0 || age > 150) {
            throw new IllegalArgumentException("Возраст недопустимый");
        }
        this.age = age;
        return this;
    }


    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (haveInfo()) {
            throw new IllegalStateException("Не хватает обяхательных полей");
        }
        return new Person(this.name, this.surname, this.age);
    }
}
