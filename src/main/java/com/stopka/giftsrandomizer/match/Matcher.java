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
            handlePersonWithoutReceiver(personList, sharedGiftsList, p);
        }
        return sharedGiftsList;
    }

    private void handlePersonWithoutReceiver(List<Person> personList, List<Person> sharedGiftsList, Person p) {
        if (p.getGiving() == null) {
            List<Person> others = getListOfOthers(personList, p);
            Person person;
            person = others.get(rand.nextInt(others.size()));
            assignGift(sharedGiftsList, p, person);

        }
    }

    private List<Person> getListOfOthers(List<Person> personList, Person p) {
        List<Person> others = new ArrayList<>();
        for (Person otherPerson : personList) {
            if (isNotSamePerson(p, otherPerson) && otherPerson.getReceiving() == null) {
                others.add(otherPerson);
            }
        }
        return others;
    }

    private void assignGift(List<Person> sharedGiftsList, Person p, Person person) {
        if (person.getReceiving() == null && isNotSamePerson(p, person) && isNotGivingSameAsReceiving(p, person)) {
            assingGiver(p, person);
            addPersonToResults(sharedGiftsList, person);
            addPersonToResults(sharedGiftsList, p);
        }
    }

    private void addPersonToResults(List<Person> sharedGiftsList, Person person) {
        if (person.getGiving() != null && person.getReceiving() != null && !sharedGiftsList.contains(person)) {
            sharedGiftsList.add(person);
        }
    }

    private void assingGiver(Person p, Person person) {
        p.setGiving(person);
        person.setReceiving(p);
    }

    private boolean isNotSamePerson(Person p, Person person) {
        return !person.getName().equals(p.getName());
    }

    private boolean isNotGivingSameAsReceiving(Person p, Person person) {
        return (person.getGiving() == null || p.getReceiving() == null) || (person.getGiving() != null && p.getReceiving() != null) && isNotSamePerson(p.getReceiving(), person.getGiving());
    }
}
