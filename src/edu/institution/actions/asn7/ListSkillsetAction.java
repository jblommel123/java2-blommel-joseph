package edu.institution.actions.asn7;

import java.util.Scanner;
import java.util.Set;

import edu.institution.ApplicationHelper;
import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class ListSkillsetAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		Set<String> loggedInUserSkills = loggedInUser.getSkillSet();
		
		if(loggedInUserSkills == null || loggedInUserSkills.isEmpty() ) {
			System.out.println("You don't have any skills to list. Add a skillset please.");
			return true;
		}
		else {
			for (String skill : loggedInUserSkills) {
				
				System.out.println("Skill: " + skill + " has " + ApplicationHelper.retrieveSkillsetCount(skill) + " users.");
			}
		}
		
		return true;
	}

}
