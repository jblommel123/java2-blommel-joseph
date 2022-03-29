package MidtermTest;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.institution.midterm.BomEntry;
import edu.institution.midterm.Part;
import edu.institution.midterm.PartManagerImpl;

public class MidtermTest {
	
	
	private static String PATH = "C:\\Users\\nicho\\joe-homework\\java2-blommel-joseph\\TestData\\";
	private static String FILE_NAME = "bom.json";
	
	private static String jsonFilePath = PATH+FILE_NAME;
	private static int numberOfParts;
	
	
	
	@Test
	public void TestRetrievePart() {
		PartManagerImpl partManagerImpl = new PartManagerImpl();
		try {
			numberOfParts = partManagerImpl.importPartStore(jsonFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Part testPart = partManagerImpl.retrievePart("290B3810C3");
		
		Part actualPart= new Part(null, null, null, 0, null);
		actualPart.setPartNumber("290B3810C3");
		actualPart.setName("Laminated steel ingot");
		actualPart.setPartType("PURCHASE");
		actualPart.setPrice(10.35f);
		actualPart.setBillOfMaterial(null);
		
		
		Assert.assertEquals(actualPart, testPart);
	}
	
	@Test
	public void TestCostPart() {
		PartManagerImpl partManagerImpl = new PartManagerImpl();
		try {
			numberOfParts = partManagerImpl.importPartStore(jsonFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(96.39f, partManagerImpl.costPart("20-0001").getPrice(), 1);
	}
	@Test
	public void TestRetrieveAssemblies() {
		PartManagerImpl partManagerImpl = new PartManagerImpl();
		try {
			numberOfParts = partManagerImpl.importPartStore(jsonFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Part> finalAssembliesList = partManagerImpl.getFinalAssemblies();
		boolean allAssemblies = true;
		for (Part part : finalAssembliesList) {
			if(!part.getPartType().equals("ASSEMBLY")) {
				allAssemblies = false;
			}
		}
		
		Assert.assertEquals(allAssemblies, true);
	}
	
	
	
	@Test
	public void TestGetPurchasePartsByPrice() {
		PartManagerImpl partManagerImpl = new PartManagerImpl();
		try {
			numberOfParts = partManagerImpl.importPartStore(jsonFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean partsSortedDescending = true;
		
		boolean isFirstItem = true;
		
		float previousPrice = 0.0f;
		
		List<Part> listOfPrices = partManagerImpl.getPurchasedPartsByPrice();
		
		for (Part part : listOfPrices) {
			if (isFirstItem ) {
				previousPrice = part.getPrice();
				isFirstItem = false;
				continue;
			}
			if (part.getPrice() >  previousPrice) {
				partsSortedDescending = false;
			}
		}
		
		Assert.assertEquals(partsSortedDescending, true);
	}
	
	
	
}
