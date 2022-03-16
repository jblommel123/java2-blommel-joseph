package edu.institution.actions.asn6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class ListUserByConnectionAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
		ArrayList<LinkedInUser> listOfUsers = (ArrayList<LinkedInUser>) userRepository.retrieveAll();
		LinkedInUserAccountNumberOfConnections compareAccountNumberOfConnections = new LinkedInUserAccountNumberOfConnections();
		
		System.out.println("Before number of connections");
		
		for (LinkedInUser linkedInUser : listOfUsers) {
			ArrayList<LinkedInUser> userConnections = (ArrayList<LinkedInUser>) linkedInUser.getConnections();
			System.out.println("user :" + linkedInUser.getUsername() + "; number of connections: " + userConnections.size());
		}
		
		Collections.sort(listOfUsers, compareAccountNumberOfConnections);
		
		System.out.println("After number of connections");
		
		for (LinkedInUser linkedInUser : listOfUsers) {
			ArrayList<LinkedInUser> userConnections = (ArrayList<LinkedInUser>) linkedInUser.getConnections();
			System.out.println("user :" + linkedInUser.getUsername() + "; number of connections: " + userConnections.size());
		}
		
		
		return true;
	}

}
