package edu.institution.actions.asn6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.actions.asn5.Utilities;
import edu.institution.asn2.LinkedInUser;

public class ListUserAlphabeticallyAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		//order users by account type in the list
		//then iterate through and say what type of account they have
		//
		Utilities utilities = new Utilities();
		ArrayList<LinkedInUser> duplicateList = new ArrayList<LinkedInUser>(userRepository.retrieveAll());
		duplicateList.addAll(userRepository.retrieveAll());
		
		System.out.println("List of duplicates before removing duplicates.");

		System.out.println("List is passed in to remove duplicates and lists out unique items.");
		utilities.removeDuplicates(duplicateList);
		
		ArrayList<LinkedInUser> listAlpahbetically = new ArrayList<LinkedInUser>(userRepository.retrieveAll());
		//test to see if users are now sorted alphabetically
		
		System.out.println("Listing users alphabetically");
		Collections.sort(listAlpahbetically);
		for (LinkedInUser linkedInUser : listAlpahbetically) {
			System.out.println(linkedInUser.getUsername());
		}
		return true;
	}

}
