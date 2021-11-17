package com.stopka.giftsrandomizer.match;

import com.stopka.giftsrandomizer.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class Matcher {
    final private Random rand = new Random();

    public List<Person> matchGifts(List<Person> personList) {
        List<Person> sharedGiftsList = new ArrayList<>();

        for (Person p : personList) {
            if (p.getGiving() == null) {
                List<Person> others = new ArrayList<>();
                for (Person otherPerson : personList) {
                    if (isNotSamePerson(p, otherPerson) && otherPerson.getReceiving() == null) {
                        others.add(otherPerson);
                    }
                }
                Person person;
                person = others.get(rand.nextInt(others.size()));
                if (person.getReceiving() == null && isNotSamePerson(p, person) && isNotGivingSameAsReceiving(p, person)) {
                    p.setGiving(person);
                    person.setReceiving(p);
                    if (person.getGiving() != null && person.getReceiving() != null && !sharedGiftsList.contains(person)) {
                        sharedGiftsList.add(person);
                    }

                    if (p.getGiving() != null && p.getReceiving() != null && !sharedGiftsList.contains(p)) {
                        sharedGiftsList.add(p);
                    }
                }

            }
        }
        return sharedGiftsList;
    }

    private boolean isNotSamePerson(Person p, Person person) {
        return !person.getName().equals(p.getName());
    }

    private boolean isNotGivingSameAsReceiving(Person p, Person person) {
        return (person.getGiving() == null || p.getReceiving() == null) || (person.getGiving() != null && p.getReceiving() != null) && isNotSamePerson(p.getReceiving(), person.getGiving());
    }
}
