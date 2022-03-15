package edu.institution.actions.asn4;

import java.util.ArrayList;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInException;
import edu.institution.asn2.LinkedInUser;
import edu.institution.actions.asn3.AddUserAction;

public class AddConnectionAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		System.out.println("What is the name of a user you would like to connect with?");
		System.out.println("Here is a list of some users as suggestions");
		int count = 0;
		for (LinkedInUser uLinkedInUser : userRepository.retrieveAll()) {
			if(uLinkedInUser.getUsername().equalsIgnoreCase(loggedInUser.getUsername())) {
				continue;
			}
			count++;
			System.out.println("Suggestion " + count + ": "+ uLinkedInUser.getUsername());
		}
		System.out.println("Enter a username to connect with: ");
		String usernameToCheck = scanner.nextLine();
		boolean usernameEnteredBlankOrEmpty = AddUserAction.checkUsernameBlankOrEmpty(usernameToCheck);
		
		if (usernameEnteredBlankOrEmpty) {
			System.out.println("That username is blank or empty text.");
			System.out.println("Exiting.");
			return true;
		}
		//make sure the user exists
		boolean userExists = AddUserAction.checkUsernameTaken((ArrayList<LinkedInUser>) userRepository.retrieveAll(), usernameToCheck);
		LinkedInUser userToConnect = new LinkedInUser();
		if(userExists) {
			userToConnect = userRepository.retrieve(usernameToCheck);
		}
		else {
			
			System.out.println("That user does not exist.");
			System.out.println("Exiting.");
			return true;
		}
		//check if the user is trying to add their own account.
		boolean usernameEnteredisLoggedInUser = usernameToCheck.equalsIgnoreCase(loggedInUser.getUsername());
		
		if (usernameEnteredisLoggedInUser) {
			System.out.println("I don't think you want to add yourself as a connection.");
			System.out.println("Exiting.");
			return true;
		}
		
		//try and add the connection
		if (userExists) {
			try {
				loggedInUser.addConnection(userToConnect);
				userToConnect.addConnection(loggedInUser);
				System.out.println("The connection was added successfully.");
				userRepository.saveAll();
			} catch (LinkedInException e) {
				System.out.println("Linked in exception: " + e.toString());
			}
		}
		
		return true;
	}

}
