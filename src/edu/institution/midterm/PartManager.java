package edu.institution.midterm;
import java.io.FileNotFoundException;
import java.util.List;

public interface PartManager {
	int importPartStore(String filePath) throws FileNotFoundException;
	Part costPart(String partNumber);
	Part retrievePart(String partNumber);
	List<Part> getFinalAssemblies();
	List<Part> getPurchasedPartsByPrice();
}
