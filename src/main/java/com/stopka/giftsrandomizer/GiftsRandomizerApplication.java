package com.stopka.giftsrandomizer;

import com.stopka.giftsrandomizer.match.Matcher;
import com.stopka.giftsrandomizer.model.Person;
import com.stopka.giftsrandomizer.utils.Printer;
import com.stopka.giftsrandomizer.utils.Writer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class GiftsRandomizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiftsRandomizerApplication.class, args);
		init();
	}

	public static void init() {
		List<Person> personList = Arrays.asList(new Person("Wojtek", "Sałek"),
				new Person("Kuba", "Sałek"),
				new Person("Judyta", "Stopka"),
				new Person("Bożena", "Sałek"),
				new Person("Tomek", "Michna"),
				new Person("Marek", "Stopka"),
				new Person("Gosia", "Michna"),
				new Person("Otylia", "Sałek"),
				new Person("Alina", "Deluga"),
				new Person("Krysia", "Deluga"),
				new Person("Henio", "Delugatar"));

		List<Person> resultsOfGiftsAssigning = new Matcher().matchGifts(personList);
		new Printer().printResults(resultsOfGiftsAssigning);
		try {
			Writer.writeIntoFile(resultsOfGiftsAssigning);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
