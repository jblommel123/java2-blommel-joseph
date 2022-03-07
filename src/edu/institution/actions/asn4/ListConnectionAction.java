package edu.institution.actions.asn4;

import java.util.ArrayList;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class ListConnectionAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		ArrayList<LinkedInUser> usersConnections = (ArrayList<LinkedInUser>) loggedInUser.getConnections();
		
		if (usersConnections.isEmpty()) {
			System.out.println("User doesn't have any connections");
			return true;
		}
		
		System.out.println(loggedInUser.getUsername() + " has the following connections:\n");
		int connectionNumber = 0;
		for( LinkedInUser connection : usersConnections) {
			connectionNumber++;
			System.out.println("Connection "+ connectionNumber + ": " + connection.getUsername() );
		}
		return true;
	}

}
