package com.github.abouopensource.restifulApiSpring.Models;

public class PersonV1 {
    Name name;

    public PersonV1(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "name=" + name +
                '}';
    }
}
