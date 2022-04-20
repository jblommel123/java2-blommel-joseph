package edu.institution.actions.asn7;

import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

import edu.institution.ApplicationHelper;
import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.actions.asn10.LinkedInAction;
import edu.institution.actions.asn10.UndoAction;
import edu.institution.asn2.LinkedInUser;

public class AddSkillsetAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
		System.out.println("Please enter the name of a skillset you want to add. Must contain at least 3 characters and no numbers.");
		String input = scanner.nextLine();
		
		Set<String> listOfSkills = loggedInUser.getSkillSet();
		
		System.out.println("Here's a list of your skills");
		
		if(listOfSkills == null || listOfSkills.isEmpty()) {
			
		}
		
		else {
			for (String string : listOfSkills) {
				System.out.println("Skill: " + string);
			}
		}
		
		
		while (input.isBlank() || input.isEmpty() || !Pattern.matches("^[a-zA-Z]{3,}", input)) {
			System.out.println("Invalid input. Please enter a skillset.");
			input = scanner.nextLine();
		}
		
		if(!loggedInUser.getSkillSet().contains(input)) {
			ApplicationHelper.incrementSkillsetCount(input);
			loggedInUser.addSkillset(input);
			userRepository.saveAll();
			LinkedInAction actionTaken = new LinkedInAction(12,"Add Skillset", input);
			UndoAction.actionHistory.push(actionTaken);
		}
		else {
			System.out.println("You already have that skillset.");
		}
		
		return true;
	}

}
