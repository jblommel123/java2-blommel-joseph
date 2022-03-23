package edu.institution.midterm;

import java.util.Comparator;

public class NumberOfPartsComparatorByPrice implements Comparator<Part> {

	@Override
	public int compare(Part o1, Part o2) {
		return (o1.getPrice() == o2.getPrice()) ? 0: (o1.getPrice() == o2.getPrice()) ? 1: -1;
	}

}
