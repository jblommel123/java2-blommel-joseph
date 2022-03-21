package edu.institution.midterm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import com.google.gson.Gson;

public class AssemblyCostStore implements PartManager {
	@Override
	public int importPartStore(String filePath) {
		try {
			FileInputStream fStream = new FileInputStream(filePath);
			
			String bomJson = fStream.toString();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		}
		
		return 1;
	}

	@Override
	public Part costPart(String partNumber) {
		return null;
	}
	@Override
	public Part retrievePart(String partNumber) {
		
		return null;
	}
	@Override
	public List<Part> getFinalAssemblies() {
		
		return null;
	}

	@Override
	public List<Part> getPurchasedPartsByPrice() {

		return null;
	}

}
