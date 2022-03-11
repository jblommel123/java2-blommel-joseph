package edu.institution.actions.asn6;

import java.util.ArrayList;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;
import edu.institution.asn5.Utilities;

public class ListUserAlphabeticallyAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		//order users by account type in the list
		//then iterate through and say what type of account they have
		//
		Utilities utilities = new Utilities();
		ArrayList<LinkedInUser> duplicateList = new ArrayList<LinkedInUser>(userRepository.retrieveAll());
		duplicateList.addAll(userRepository.retrieveAll());
		
		System.out.println("List of duplicates list before.");
		utilities.removeDuplicates(duplicateList);
		
		System.out.println("See if duplicates were removed.");
		utilities.listItems(duplicateList);
		
		return true;
	}

}
