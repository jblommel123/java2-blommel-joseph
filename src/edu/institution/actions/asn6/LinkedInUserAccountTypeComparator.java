package edu.institution.actions.asn6;

import java.util.Comparator;

import edu.institution.asn2.LinkedInUser;


//helper class for comparing multiple properties with comparator
	// https://www.geeksforgeeks.org/comparator-interface-java/
public class LinkedInUserAccountTypeComparator implements Comparator<LinkedInUser>{

	@Override
	public int compare(LinkedInUser o1, LinkedInUser o2) {
		int compareName = o1.getUsername().compareToIgnoreCase(o2.getUsername());
		int compareAccountType = o1.getType().compareToIgnoreCase(o2.getType());
		return (compareAccountType == 0) ? compareName : compareAccountType;
	}
	
}