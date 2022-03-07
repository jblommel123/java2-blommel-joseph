package edu.institution.actions.asn3;

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
		List<LinkedInUser> users = userRepository.retrieveAll();
		//check if user exists
		boolean userNameExists = checkUsernameExists(users, userNameToSearch);
		
		if(userNameExists) {
			LinkedInUser userToDelete = userRepository.retrieve(userNameToSearch);
			System.out.println("Please enter the username's password. This will exit if the password is incorrect.");
			String passwordString = scanner.nextLine();
			boolean passwordIsCorrect = checkPasswordIsCorrect(userToDelete, passwordString);
			boolean userToDeleteIsLoggedInUser = userNameToSearch.equalsIgnoreCase(userNameToSearch);
			if (!passwordIsCorrect) {
				System.out.println("That password is not correct");
				System.out.println("Back to main menu.");
				
			}
			if(passwordIsCorrect && !userToDeleteIsLoggedInUser) {
				userRepository.delete(userToDelete);
				userRepository.saveAll();
				return false;
			}
			
			if (passwordIsCorrect && userToDeleteIsLoggedInUser) {
				userRepository.delete(userToDelete);
				userRepository.saveAll();
				return true;
			}
			
		}
		else {
			System.out.println("User doesn't exist. Going to the main menu.");
			return true;
		}
		return true;
		
		
	}
	
	public boolean checkUsernameExists (List<LinkedInUser> users, String usernameToCheck) {
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
