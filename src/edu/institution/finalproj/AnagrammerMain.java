package edu.institution.finalproj;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PrimitiveIterator.OfDouble;
import java.util.function.IntBinaryOperator;

import javax.management.loading.PrivateClassLoader;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.validator.PublicClassValidator;

public class AnagrammerMain {
	private static String PATH = System.getProperty("user.home") + File.separator + "Java2" + File.separator;
	private static String FILE = "anagram_data.txt";
	public static void main(String[] args) throws ParseException {
		List<String> webstersDictionary = new ArrayList<String>();
		//read in the text from the data file
		try {
			webstersDictionary = Files.readAllLines(Paths.get(System.getProperty("user.home") + File.separator + "Java2" + File.separator +"anagram_data.txt"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("Welcome to the Anagram program.");
		
		System.out.println("Please enter a word you would like to see an anagram for: ");
		try (Scanner inputScanner = new Scanner(System.in)) {
			String inputString = inputScanner.nextLine();
			ArrayList<String>  listOfPermutations = new ArrayList<String>();
			char[] characters = inputString.toCharArray();
			
			
			AnagrammerMain.permute(inputString, 0, characters.length - 1,listOfPermutations);
			
			System.out.println("Check the list for real world.");
			for (String c : listOfPermutations) {
				 
				if(webstersDictionary.contains(c.toUpperCase())) {
					System.out.println(c);
				}
				else {
					continue;
				}
			}
		}
		
//		ArrayList<String> commandLineArguments = new ArrayList<String>();
//		
//		
//		//Create command line options
//		Options options = new Options();
//		
//		options.addOption("a",true,"Supplies the anagram to evaluate.");
//		options.addOption("anagram",true, "Supplies the anagram to evaluate");
//		options.addOption("nf", false, "Output all anagram values with no filter.");
//		options.addOption("noFilter",false,"Output all anagram values with no filter.");
//		options.addOption("h",false,"Displays the help for this program");
//		options.addOption("help",false,"Displays the help for this program");
//		
//		HelpFormatter formatter = new HelpFormatter();
//		formatter.printHelp("help", options);
//		
//		CommandLineParser parser = new DefaultParser();
//		CommandLine cmd = parser.parse(options, args);
		
	   }
	   
	   
	   
	   //https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
	private static void permute(String str, int l, int r, ArrayList<String> listToPopulate)
	{
		if (l == r) {
			listToPopulate.add(str);
			System.out.println(str);
		}
		else
		{
			for (int i = l; i <= r; i++)
			{
				str = swap(str,l,i);
				permute(str, l+1, r, listToPopulate);
				str = swap(str,l,i);
				
			}
		}
	}
	   
	   public static String swap(String a, int i , int j) {
		   char temp;
			char[] charArray = a.toCharArray();
			temp = charArray[i] ;
			charArray[i] = charArray[j];
			charArray[j] = temp;
			return String.valueOf(charArray);
	   }

}
