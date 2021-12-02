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
public class GiftsPairMatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiftsPairMatcherApplication.class, args);
		init();
	}

	public static void init() {
		List<Person> personList = Arrays.asList(new Person("Judyta", "Stopka"),
				new Person("Marek", "Stopka"),
				new Person("Bożena", "Sałek"),
				new Person("Otylia", "Sałek"),
				new Person("Wojciech", "Sałek"),
				new Person("Jakub", "Sałek"),
				new Person("Małgorzata", "Michna"),
				new Person("Alina", "Deluga"),
				new Person("Tomasz", "Michna"),
				new Person("Krystyna", "Deluga"),
				new Person("Henryk", "Deluga"));

		List<Person> resultsOfGiftsAssigning = new Matcher().matchGifts(personList);
		Printer.printResults(resultsOfGiftsAssigning);
		try {
			Writer.writeIntotFile(resultsOfGiftsAssigning);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
