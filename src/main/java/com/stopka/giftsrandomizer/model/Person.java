package com.stopka.giftsrandomizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    private Long id;
    private String name;
    private String surname;

    private Person giving;
    private Person receiving;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


}
