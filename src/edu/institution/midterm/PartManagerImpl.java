package edu.institution.midterm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.validation.SchemaFactoryLoader;

import org.junit.platform.engine.support.hierarchical.ForkJoinPoolHierarchicalTestExecutorService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PartManagerImpl implements PartManager {
	Part[] parts;
	
	@Override
	public int importPartStore(String filePath) throws FileNotFoundException {
			int numberOfParts = 0;
			
				try {
					String jsonFile = filePath+"bom.json";
					Path fileNamePath = Path.of(filePath);
					String bomJson = Files.readString(fileNamePath);
					Gson gson = new Gson();
					parts  = gson.fromJson(bomJson, Part[].class);
					numberOfParts = parts.length;
				}
		
			catch (Exception e) {
				System.out.println(e.toString());
			}
			
		return numberOfParts;
	}

	@Override
	public Part costPart(String partNumber) {
		Part partToCost = null;
		boolean partFound = false;
		for (Part part : parts) {
			if(part.getPartNumber().equalsIgnoreCase(partNumber)) {
				partToCost = part;
				partFound = true;
			}
		}
		
		float extendedPrice = 0.0f;
		
		if(partToCost.getBillOfMaterial().isEmpty()) {
			extendedPrice = 1* partToCost.getPrice();
		}
		
		else {
			List<BomEntry> listOfSubcomponents = partToCost.getBillOfMaterial();
			for (BomEntry bomEntry : listOfSubcomponents) {
				Part subComponent = retrievePart(partNumber);
				extendedPrice += (bomEntry.getQuantity() * costPart(subComponent.getPartNumber()).getPrice());
			}
			partToCost.setPrice(extendedPrice);
		}
		
		
		
		return partToCost;
		
	}
	
	private float roundForMoney(float value) {
		return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).floatValue();
	}
	
	@Override
	public Part retrievePart(String partNumber) {
		if(partNumber.isBlank() || partNumber.isEmpty()) {
			System.out.println("Part not found. Returned null.");
			return null;
		}
		for (Part part : parts) {
			if(part.getPartNumber().equalsIgnoreCase(partNumber)) {
				System.out.println("Part found. The part is: " + part.getName());
				return part;
			}
		}
		
		System.out.println("Part not found. Returning null.");
		return null;
	}
	@Override
	public List<Part> getFinalAssemblies() {
		List<Part> finalAssembliesList = new ArrayList<Part>();
		for (Part part : parts) {
			if (part.getPartType().equalsIgnoreCase("ASSEMBLY")) {
				finalAssembliesList.add(part);
			}
		}
		
		return finalAssembliesList;
	}

	@Override
	public List<Part> getPurchasedPartsByPrice() {
		List<Part> purchaseParts = new ArrayList<Part>();
		for (Part part : parts) {
			if(part.getPartType().equalsIgnoreCase("PURCHASE")) {
				purchaseParts.add(part);
			}
		}
		
		NumberOfPartsComparatorByPrice compareByPriceDesc = new NumberOfPartsComparatorByPrice();
		Collections.sort(purchaseParts,compareByPriceDesc);
		
		return purchaseParts;
		
		//sort the parts by highest to lowest price
		
	}

}
