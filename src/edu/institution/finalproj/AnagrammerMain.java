package edu.institution.finalproj;

import java.io.File;
import java.lang.invoke.StringConcatFactory;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Option.Builder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class AnagrammerMain {
	public static void main(String[] args) throws ParseException {
		
//		System.out.println("Welcome to the Anagram program.");
//		
//		System.out.println("Please enter a word you would like to see an anagram for: ");
//		try (Scanner inputScanner = new Scanner(System.in)) {
//			String inputString = inputScanner.nextLine();
//			
//			char[] characters = inputString.toCharArray();
//			
//			
//			AnagrammerMain.permute(inputString, 0, characters.length - 1,listOfPermutations);
//			
//			
//		}
		
		//Create command line options
		Options options = new Options();
		
		Option anagram = Option.builder()
				.argName("a")
				.longOpt("anagram")
				.hasArg(true)
				.desc("Supplies the anagram to evaluate.")
				.required()
				.build();
		
		Option filterOption = Option.builder()
				.argName("nf")
				.longOpt("no-filter")
				.hasArg(false)
				.desc("Filter out only real words or every combination")
				.optionalArg(true)
				.build();
		
		Option wordsOption = Option.builder()
				.argName("words")
				.longOpt("filter-words")
				.hasArg(false)
				.optionalArg(true)
				.desc("Only return real words")
				.build();
		
		Option helpOption = Option.builder()
				.argName("h")
				.longOpt("help")
				.hasArg(false)
				.optionalArg(true)
				.desc("Display Help")
				.build();
		
		options.addOption(anagram);
		options.addOption(filterOption);
		options.addOption(helpOption);
		options.addOption(wordsOption);
		
		
		
		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse(options, args);
		
		String anagramWord = (String) cmd.getParsedOptionValue("anagram");
		AnagramEvaluatorImpl evaluatorImpl = new AnagramEvaluatorImpl();
		List<String> anagrams;
		//evaluate command line arguments
		
		if (cmd.hasOption("help")) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("help", options);
		}
		
		if(cmd.hasOption("nf")) {
			 anagrams = evaluatorImpl.evaluate(anagramWord, "nf");
		}
		
		else {
			 anagrams = evaluatorImpl.evaluate(anagramWord, "words");
		}
		
		for (String anagram1 : anagrams) {
			System.out.println(anagram1);
		}
	   
	   
	}
	

}
