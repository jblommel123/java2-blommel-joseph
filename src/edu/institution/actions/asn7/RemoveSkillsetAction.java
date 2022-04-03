package edu.institution.actions.asn7;

import java.util.Scanner;
import java.util.regex.Pattern;

import edu.institution.ApplicationHelper;
import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class RemoveSkillsetAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		System.out.println("Please enter the name of a skillset you want to remove. Must contain at least 3 characters and no numbers.");
		String input = scanner.nextLine();
		
		while (input.isBlank() || input.isEmpty() || !Pattern.matches("[a-zA-Z]{3,}", input)) {
			System.out.println("Invalid input. Please enter a skillset.");
			scanner.nextLine();
		}
		ApplicationHelper.decreaseSkillsetCount(input);
		loggedInUser.getSkillSet().remove(input);
		System.out.println( input + " removed");
		return true;
	}

}
