package com.stopka.giftsrandomizer.utils;

import com.stopka.giftsrandomizer.model.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class Writer {

    public static void writeIntoFile(List<Person> results) throws IOException {
        FileWriter fw = new FileWriter("family.txt");

        fw.write("|Daje   |  Otrzymuje   |\n");
        for (Person p : results) {
            fw.write("|  " + p.getName() + " |  " + p.getGiving().getName() + "  |\n");
        }
        fw.write("|__________|__________");

        fw.close();
    }
}
