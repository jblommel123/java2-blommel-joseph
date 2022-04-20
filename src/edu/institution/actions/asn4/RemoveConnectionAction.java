package edu.institution.actions.asn4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.actions.asn10.LinkedInAction;
import edu.institution.actions.asn10.UndoAction;
import edu.institution.asn2.LinkedInException;
import edu.institution.asn2.LinkedInUser;
import edu.institution.actions.asn3.AddUserAction;

public class RemoveConnectionAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		List<LinkedInUser> connections = loggedInUser.getConnections();
		if (connections.isEmpty()) {
			System.out.println("You have no connections. Please add a connection before trying to remove one.");
			return true;
		}
		System.out.println("Enter a connection to remove: ");
		int count = 0;
		for (LinkedInUser linkedInUser : connections) {
			count++;
			System.out.println("Connection " + count + ": " + linkedInUser.getUsername());
		}
		
		String userToRemoveString = scanner.nextLine();
		boolean usernameIsNotBlankOrEmpty = AddUserAction.checkUsernameBlankOrEmpty(userToRemoveString);
		boolean usernameIsAConnection = AddUserAction.checkUsernameTaken((ArrayList<LinkedInUser>) connections, userToRemoveString);
		boolean userExists = AddUserAction.checkUsernameTaken((ArrayList<LinkedInUser>) userRepository.retrieveAll(), userToRemoveString);
		if (!usernameIsNotBlankOrEmpty && !usernameIsAConnection) {
			System.out.println("The username you entered was blank, empty, or not one of your connections.");
			System.out.println("Exiting");
			return true;
		}
		
		LinkedInUser userRetrieved = userRepository.retrieve(userToRemoveString);
		
		if (userExists && usernameIsAConnection) {
			try {
				loggedInUser.removeConnection(userRetrieved);
				userRetrieved.removeConnection(loggedInUser);
				userRepository.saveAll();
				LinkedInAction actionTaken = new LinkedInAction(7,"Remove Connection", userRetrieved);
				UndoAction.actionHistory.push(actionTaken);
			} catch (LinkedInException e) {
				System.out.println(e.toString());
			}
		}
		
		else {
			System.out.println("Action could not be compeleted. \nExiting.");
		}
		
		return true;
	}

}
