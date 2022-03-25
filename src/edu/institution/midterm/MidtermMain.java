package edu.institution.midterm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MidtermMain {
	private static String PATH = System.getProperty("user.home") + File.separator + "Java2" + File.separator;
	private static String FILE_NAME = "bom.json";
	
	private static String jsonFilePath = PATH+FILE_NAME;
	private static int numberOfParts;

	public static void main(String[] args) throws FileNotFoundException {
		PartManagerImpl partManagerImpl = new PartManagerImpl();
		numberOfParts = partManagerImpl.importPartStore(jsonFilePath);
		System.out.println("The number of parts in the list is " + numberOfParts);
		List<Part> listOfParts = new ArrayList<Part>();
		listOfParts = partManagerImpl.getPurchasedPartsByPrice();
		
		for (Part part : listOfParts) {
			System.out.println("Part number is " + part.getPartNumber() + " and the price is " + part.getPrice());
		}
		
	}

}
