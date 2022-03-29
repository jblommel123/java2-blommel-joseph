package edu.institution.midterm;

import java.util.Comparator;

public class SortAssembyPartsByName implements Comparator<Part> {

	@Override
	public int compare(Part o1, Part o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
