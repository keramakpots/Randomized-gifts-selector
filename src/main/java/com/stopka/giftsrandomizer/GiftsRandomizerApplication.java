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
		List<Person> personList = Arrays.asList(new Person("John", "Stopka"),
				new Person("Jane", "Stopka"),
				new Person("Josephine", "Stopka"),
				new Person("Janet", "Stopka"),
				new Person("Warner", "Stopka"),
				new Person("Marek", "Stopka"),
				new Person("Anton", "Stopka"),
				new Person("Juliusz", "Stopka"),
				new Person("Kornel", "Stopka"),
				new Person("Adam", "Stopka"));

		List<Person> resultsOfGiftsAssigning = new Matcher().matchGifts(personList);
		Printer.printResults(resultsOfGiftsAssigning);
		try {
			Writer.writeIntotFile(resultsOfGiftsAssigning);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
