package edu.institution.actions.asn3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class DeleteUserAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		System.out.println("Please enter the username to delete: ");
		String userNameToSearch = scanner.nextLine();
		
		boolean userToDeleteIsLoggedInUser = loggedInUser.getUsername().equalsIgnoreCase(userNameToSearch);
		
		String answer = "";
		if (userToDeleteIsLoggedInUser) {
			System.out.println("Are you sure you want to delete your account?");
			System.out.println("Please enter Y to continue");
			answer = scanner.next();
		}
		
		boolean userWantsToDeleteTheirAccount = false;
		
		if(answer.equalsIgnoreCase("Y")) {
			userWantsToDeleteTheirAccount = true;
		}
		
		
		ArrayList<LinkedInUser> users = (ArrayList<LinkedInUser>) userRepository.retrieveAll();
		//check if user exists
		boolean userNameExists = checkUsernameExists(users, userNameToSearch);
		
		
		
		if(userNameExists) {
			LinkedInUser userToDelete = userRepository.retrieve(userNameToSearch);
			System.out.println("Please enter the username's password. This will exit if the password is incorrect.");
			String passwordString = scanner.nextLine();
			boolean passwordIsCorrect = checkPasswordIsCorrect(userToDelete, passwordString);
			
			if (!passwordIsCorrect) {
				System.out.println("That password is not correct");
				System.out.println("Back to main menu.");
				
			}
			if(passwordIsCorrect && !userToDeleteIsLoggedInUser) {
				userRepository.delete(userToDelete);
				userRepository.saveAll();
				return false;
			}
			
			if (passwordIsCorrect && userToDeleteIsLoggedInUser && userWantsToDeleteTheirAccount) {
				userRepository.delete(userToDelete);
				userRepository.saveAll();
				return true;
			}
			
			else {
				System.out.println("Did not delete your account. Going back to menu.");
				return true;
			}
			
		}
		else {
			System.out.println("Could not complete action. Going to the main menu.");
			return true;
		}
		
		
	}
	
	public boolean checkUsernameExists (ArrayList<LinkedInUser> users, String usernameToCheck) {
		for(LinkedInUser user : users) {
			if(usernameToCheck.equalsIgnoreCase(user.getUsername())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkPasswordIsCorrect (LinkedInUser user, String passwordToCheck) {
		if (passwordToCheck.equalsIgnoreCase(user.getPassword())) {
			return true;
		}
		return false;
	}

}
