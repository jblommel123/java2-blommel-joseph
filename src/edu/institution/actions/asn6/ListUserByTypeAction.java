package edu.institution.actions.asn6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class ListUserByTypeAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		ArrayList<LinkedInUser> userList = (ArrayList<LinkedInUser>)userRepository.retrieveAll();
		Collections.sort(userList, new LinkedInUserAccountTypeComparator());
		for (LinkedInUser linkedInUser : userList) {
			System.out.println("User: " + linkedInUser.getUsername() + "; Account Type = " + linkedInUser.getType());
		}
		return true;
	}

}
