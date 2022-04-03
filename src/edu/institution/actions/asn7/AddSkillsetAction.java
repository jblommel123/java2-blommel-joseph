package edu.institution.actions.asn7;

import java.util.Scanner;
import java.util.regex.Pattern;

import edu.institution.ApplicationHelper;
import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class AddSkillsetAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
		System.out.println("Please enter the name of a skillset you want to add. Must contain at least 3 characters and no numbers.");
		String input = scanner.nextLine();
		
		while (input.isBlank() || input.isEmpty()) {
			System.out.println("Invalid input. Please enter a skillset.");
			scanner.nextLine();
		}
		ApplicationHelper.incrementSkillsetCount(input);
		loggedInUser.addSkillset(input);
		return true;
	}

}
