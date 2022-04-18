package edu.institution.actions.asn3;

import java.util.ArrayList;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.actions.asn10.LinkedInAction;
import edu.institution.asn2.LinkedInException;
import edu.institution.asn2.LinkedInUser;

public class AddUserAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		// get username, password, and account type, then add the user to the list
		//make sure username is unique, and the account type is valid before adding
		
		
		ArrayList<LinkedInUser> users = (ArrayList<LinkedInUser>) userRepository.retrieveAll();
		
		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		
		
		boolean usernameBlankOrEmpty = checkUsernameBlankOrEmpty(username);
		boolean usernameIsTaken = checkUsernameTaken(users,username);
		while(usernameIsTaken || usernameBlankOrEmpty) {
			System.out.println("");
			username = scanner.nextLine();
			usernameBlankOrEmpty = checkUsernameBlankOrEmpty(username);
			usernameIsTaken = checkUsernameTaken(users,username);
		}
		
		System.out.println("Enter a new password: ");
		String password = scanner.nextLine();
		boolean passwordIsBlankOrEmpty = checkPasswordIsBlankOrEmpty(password);
		while(passwordIsBlankOrEmpty) {
			System.out.println("Password cannot be blank or empty.\nPlease enter a new password: ");
			password = scanner.nextLine();
			passwordIsBlankOrEmpty = checkPasswordIsBlankOrEmpty(password);
		}
		
		
		System.out.println("Enter P or p for Premier account or S or s for Standard.");
		String accountType = scanner.nextLine();
		boolean accountTypeIsCorrect = accountTypeIsCorrect(accountType);
		while(!accountTypeIsCorrect) {
			System.out.println("That is not one of the account types. Enter P for Premier account or S for standard.");
			accountType = scanner.nextLine();
			accountTypeIsCorrect = accountTypeIsCorrect(accountType);
		}
		
		LinkedInUser newUser = new LinkedInUser(username,password);
		newUser.setType(accountType);
		boolean userAdded = false;
		try {
			userRepository.add(newUser);
			userAdded = true;
		} catch (LinkedInException e) {
			System.out.println("In catch for linked in exception" + e.toString());
		}
		
		return userAdded;
	}
	
	public static boolean checkUsernameTaken (ArrayList<LinkedInUser> list, String usernameToCheck) {
		for(LinkedInUser user : list) {
			if(usernameToCheck.equalsIgnoreCase(user.getUsername())) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkUsernameBlankOrEmpty(String usernameToCheck) {
		if (usernameToCheck.isBlank() || usernameToCheck.isEmpty()) {
			System.out.println("Username is taken, blank or empty.\nPlease enter a new username: ");
			return true;
		}
		return false;
	}
	
	public static boolean checkPasswordIsBlankOrEmpty(String passwordToCheck) {
		if(passwordToCheck.isBlank() || passwordToCheck.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static boolean accountTypeIsCorrect(String accountType) {
		if(accountType.equalsIgnoreCase("P") || accountType.equalsIgnoreCase("S")) {
			return true;
		}
		return false;
	}

}
