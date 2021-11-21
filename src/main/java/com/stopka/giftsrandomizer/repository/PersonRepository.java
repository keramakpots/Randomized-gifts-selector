package com.stopka.giftsrandomizer.repository;

import com.stopka.giftsrandomizer.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
