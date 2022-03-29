package edu.institution.midterm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MidtermMain {
	private static String PATH = "C:\\Users\\nicho\\joe-homework\\java2-blommel-joseph\\TestData\\";
	private static String FILE_NAME = "bom.json";
	
	private static String jsonFilePath = PATH+FILE_NAME;
	private static int numberOfParts;

	public static void main(String[] args) throws FileNotFoundException {
		PartManagerImpl partManagerImpl = new PartManagerImpl();
		numberOfParts = partManagerImpl.importPartStore(jsonFilePath);
		System.out.println("The number of parts in the list is " + numberOfParts);
		List<Part> listOfParts = new ArrayList<Part>();
		listOfParts = partManagerImpl.getPurchasedPartsByPrice();
		
		List<Part> partsSortedByName = partManagerImpl.getFinalAssemblies();
		
		for (Part part : partsSortedByName) {
			System.out.println( "Part type :" + part.getPartType() +"; Part name: " + part.getName());
		}
		
		String testPartNumberString = "290B7266J6";
		Part testPart = partManagerImpl.retrievePart(testPartNumberString);
		partManagerImpl.costPart(testPart.getPartNumber());
		System.out.println("Test Part price is $" + partManagerImpl.roundForMoney(testPart.getPrice()));
		
	}

}
