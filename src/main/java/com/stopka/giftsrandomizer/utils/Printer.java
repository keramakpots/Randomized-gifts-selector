package com.stopka.giftsrandomizer.utils;

import com.stopka.giftsrandomizer.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Printer {
    Logger logger = LoggerFactory.getLogger(Printer.class);

    public void printResults(List<Person> results) {
        logger.info("|  Daje   |  Otrzymuje   |\n");
        for (Person p : results) {
            logger.info("|  " + p.getName() + " |  " + p.getGiving().getName() + "  |\n");
        }
        logger.info("|__________|__________");
    }
}
