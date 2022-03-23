package edu.institution.midterm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.platform.engine.support.hierarchical.ForkJoinPoolHierarchicalTestExecutorService;

import com.google.gson.Gson;

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
		return null;
	}
	@Override
	public Part retrievePart(String partNumber) {
		if(partNumber.isBlank() || partNumber.isEmpty()) {
			
		}
		for (Part part : parts) {
			if(part.getPartNumber().equalsIgnoreCase(partNumber)) {
				return part;
			}
			else {
				System.out.println("part not found. exiting");
			}
		}
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
		return purchaseParts;
		
		//sort the parts by highest to lowest price
		
	}

}
