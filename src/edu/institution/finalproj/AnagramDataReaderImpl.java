package edu.institution.finalproj;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnagramDataReaderImpl implements AnagramDataReader {

	@Override
	public Set<String> readData() {
		List<String> webstersDictionary = new ArrayList<String>();
		//read in the text from the data file
		try {
			webstersDictionary = Files.readAllLines(Paths.get(System.getProperty("user.home") + File.separator + "Java2" + File.separator +"anagram_data.txt"));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		Set<String> wordSet = new HashSet<String>(webstersDictionary);
		return wordSet;
	}

}
