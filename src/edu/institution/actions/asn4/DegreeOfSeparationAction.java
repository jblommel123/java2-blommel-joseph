package edu.institution.actions.asn4;
import java.util.ArrayList;
import java.util.Scanner;
import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;
import edu.institution.actions.asn3.AddUserAction;

public class DegreeOfSeparationAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
		System.out.println("Who would you like to see who is your friend of a friend of a friend?");
		int count = 0;
		ArrayList<LinkedInUser> listOfUsers = (ArrayList<LinkedInUser>) userRepository.retrieveAll();
		
		for (LinkedInUser user : listOfUsers) {
			if(user.getUsername().equalsIgnoreCase(loggedInUser.getUsername())) {
				continue;
			}
			count++;
			System.out.println("Suggestion " + count +": " + user.getUsername());
		}
		
		System.out.println("Who would you like to look for? ");
		String usernameToCheck = scanner.nextLine();
		
		boolean usernameBlankOrEmpty = AddUserAction.checkUsernameBlankOrEmpty(usernameToCheck);
		boolean userExists = false;
		//check if username exists
		if(!usernameBlankOrEmpty) {
			userExists = AddUserAction.checkUsernameTaken(listOfUsers, usernameToCheck);
			
		}
		if(usernameBlankOrEmpty) {
			System.out.println("Username is blank, doesn't exist, or empty.");
			System.out.println("Exiting");
			return true;
		}
		
		if (userExists) {
			LinkedInUser userSearchingFor = userRepository.retrieve(usernameToCheck);
			StringBuffer degreeOfSepartionMessage = new StringBuffer();
			degreeOfSepartionMessage.append(loggedInUser.getUsername() + " -> ");
			ArrayList<LinkedInUser> listOfUsersFound = new ArrayList<LinkedInUser>();
			ArrayList<LinkedInUser> listOfConnectionsForMessage = new ArrayList<LinkedInUser>();
			ArrayList<LinkedInUser> listOfConnections = new ArrayList<LinkedInUser>();
			listOfConnections = (ArrayList<LinkedInUser>) loggedInUser.getConnections();
			listOfUsersFound.add(loggedInUser);
			getDegreesOfSeparation(listOfConnections, listOfUsersFound,listOfConnectionsForMessage ,userSearchingFor, 0, degreeOfSepartionMessage);
		}
		
		return true;
	}
	
	public void getDegreesOfSeparation(ArrayList<LinkedInUser> listOfConnections,
			ArrayList<LinkedInUser> usersAlreadyFound,
			ArrayList<LinkedInUser> usersForMessage,
			LinkedInUser userSearchingFor, 
			int degreesOfSeparation, 
			StringBuffer degreeOfSeparationMessage) {
		
		if(listOfConnections.isEmpty()) {
			return;
		}
		
		boolean userFound = false;
		
		//iterate through connections and see if one is the user.
		for (LinkedInUser linkedInUser : listOfConnections) {
			
			if(linkedInUser.equals(userSearchingFor)) {
				userFound = true;
				usersForMessage.add(linkedInUser);
				break;
			}
			
		}
		
		if(userFound) {
			
			for (int i = 0; i < usersForMessage.size(); i++) {
				if (i == (usersForMessage.size() - 1)) {
					degreeOfSeparationMessage.append(usersForMessage.get(i).getUsername());
				}
				
				else {
					degreeOfSeparationMessage.append(usersForMessage.get(i).getUsername() + " -> ");
				}
			}
			
			System.out.println("There are " + (usersForMessage.size() - 1) + " degree(s) of separtion between " + userSearchingFor.getUsername()  + " and you.");
			System.out.println(degreeOfSeparationMessage.toString());
			return;
		}
		
		if (!userFound && usersAlreadyFound.containsAll(listOfConnections)) {
			
			System.out.println("Path taken:");
			
			for (LinkedInUser linkedInUser : usersForMessage) {
				System.out.println(linkedInUser.getUsername());
			}
			System.out.println("Connection not found.");
			return;
		}
		
		else {
			
			degreesOfSeparation++;
			
			for (LinkedInUser linkedInUser : listOfConnections) {
				//create new lists for recursive calls
				if (usersAlreadyFound.contains(linkedInUser)) {
					continue;
				}
				usersAlreadyFound.add(linkedInUser);
					//only evaluating the first connection, need to figure out how to hit the next connection
					ArrayList<LinkedInUser> nextLevelListOfConnections = new ArrayList<LinkedInUser>();
					ArrayList<LinkedInUser> nextLevelListOfUsersForMessage = new ArrayList<LinkedInUser>();
					nextLevelListOfConnections.addAll(linkedInUser.getConnections());
					nextLevelListOfUsersForMessage.addAll(usersForMessage);
					nextLevelListOfUsersForMessage.add(linkedInUser);
					getDegreesOfSeparation(nextLevelListOfConnections, usersAlreadyFound, nextLevelListOfUsersForMessage, userSearchingFor, degreesOfSeparation, degreeOfSeparationMessage);
				
			}
		}
	}
	
}

