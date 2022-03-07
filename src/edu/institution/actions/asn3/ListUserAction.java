package edu.institution.actions.asn3;

import java.util.Scanner;
import java.util.List;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class ListUserAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		// needs to loop through user repository and list all users for you
		List<LinkedInUser> users = userRepository.retrieveAll();
		if(users == null || users.isEmpty()) {
			System.out.println("There are no users.");
		}
		else {
			for(LinkedInUser userToList: users) {
				System.out.println("Username: " + userToList.getUsername());
			}
		}
		return true;
	}
}
