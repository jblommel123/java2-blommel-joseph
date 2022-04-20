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

public class RemoveSkillsetAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		Set<String> listOfSkills = loggedInUser.getSkillSet();
		System.out.println("Here's a list of your skills");
		
		if(listOfSkills == null || listOfSkills.isEmpty()) {
			System.out.println("You don't have any skills. Please add one before trying to remove a skillset.");
			return true;
		}
		
		for (String string : listOfSkills) {
			System.out.println("Skill: " + string);
		}
		System.out.println("Please enter the name of a skillset you want to remove. Must contain at least 3 characters and no numbers.");
		String input = scanner.nextLine();
		
		while (input.isBlank() || input.isEmpty() || !Pattern.matches("^[a-zA-Z]{3,}", input)) {
			System.out.println("Invalid input. Please enter a skillset.");
			input = scanner.nextLine();
		}
		
		if(loggedInUser.getSkillSet().contains(input)) {
			ApplicationHelper.decreaseSkillsetCount(input);
			loggedInUser.getSkillSet().remove(input);
			userRepository.saveAll();
			System.out.println( input + " removed");
			LinkedInAction actionTaken = new LinkedInAction(13,"Remove Skillset",input);
			UndoAction.actionHistory.push(actionTaken);
		}
		
		else {
			System.out.println("You cannot remove a skillset you don't have.");
		}
		
		return true;
	}

}
