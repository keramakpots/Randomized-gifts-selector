package com.stopka.giftsrandomizer.utils;

import com.stopka.giftsrandomizer.model.Person;

import java.util.List;

public abstract class Printer {

    public static void printResults(List<Person> results) {
        System.out.println("|Daje   |  Otrzymuje   |");
        for (Person p : results) {
            System.out.println("|  " + p.getName() + " |  " + p.getGiving().getName() + "  |");
        }
        System.out.println("|__________|__________");
    }
}
