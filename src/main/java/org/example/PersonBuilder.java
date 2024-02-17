package org.example;

public class PersonBuilder {
    public String name;
    public String surname;
    public int age;
    public boolean haveInfo;
    public String address;

    public PersonBuilder() {
        this.haveInfo = false;
    }

    public PersonBuilder setHaveInfo() {
        this.haveInfo = true;
        return this;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        setHaveInfo();
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        setHaveInfo();
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
        if (!this.haveInfo) {
            throw new IllegalStateException("Не хватает обяхательных полей");
        }
        return new Person(this.name, this.surname);
    }
}
