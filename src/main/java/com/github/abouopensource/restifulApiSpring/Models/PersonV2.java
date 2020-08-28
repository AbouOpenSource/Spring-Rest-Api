package com.github.abouopensource.restifulApiSpring.Models;

public class PersonV2 {
    String name;

    public PersonV2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "name='" + name + '\'' +
                '}';
    }
}
