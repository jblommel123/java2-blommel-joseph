package edu.institution.actions.asn10;

import java.util.Scanner;
import java.util.Stack;

import edu.institution.ApplicationController;
import edu.institution.ApplicationHelper;
import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.actions.asn4.RemoveConnectionAction;
import edu.institution.asn2.LinkedInException;
import edu.institution.asn2.LinkedInUser;

public class UndoAction implements MenuAction {
	
	public static Stack<LinkedInAction> actionHistory = new Stack<LinkedInAction>();
	
	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
		if(actionHistory.isEmpty()) {
			System.out.println("There is nothing left to undo. You need to perform an action to be able to undo it.");
			return true;
		}
		
		//check the last action performed
		
		System.out.println("The last action was " );
		LinkedInAction lastAction = actionHistory.peek();
		
		
		//
		System.out.println("The last action performed was" + lastAction.getMenuTitle()+ " by " + lastAction.getDataObject().toString());
		System.out.println("Would you like to undo that last action? Enter Y or y to undo the last action, \notherwise anything else entered will go back to the main menu");
		
		String inputString = scanner.nextLine();
		
		//
		if(inputString.equalsIgnoreCase("y")) {
			
			
			LinkedInAction action = actionHistory.pop();
			
			int actionTaken = action.getMenuOption();
			
			switch (actionTaken) {
			
			case 2:
				LinkedInUser userToDelete = (LinkedInUser) action.getDataObject();
				userRepository.delete(userToDelete);
				break;
			case 3:
				LinkedInUser userToAdd = (LinkedInUser) action.getDataObject();
				try {
					userRepository.add(userToAdd);
				} catch (LinkedInException e) {
					e.printStackTrace();
				}
			
			case 6:
				LinkedInUser userToRemove = (LinkedInUser) action.getDataObject();
				try {
					loggedInUser.removeConnection(userToRemove);
				} catch (LinkedInException e) {
					e.printStackTrace();
				}
				break;
			
			case 7:
				LinkedInUser userToAddConnection = (LinkedInUser) action.getDataObject();
				try {
					loggedInUser.addConnection(userToAddConnection);
				} catch (LinkedInException e) {
					e.printStackTrace();
				}
				break;
			case 12:
				String skillsetToRemove = (String) action.getDataObject();
				loggedInUser.removeSkillset(skillsetToRemove);
				ApplicationHelper.decreaseSkillsetCount(skillsetToRemove);
				System.out.println("Skillset removed by undo action");
				break;
			case 13:
				String skillSetToAdd = (String) action.getDataObject();
				loggedInUser.addSkillset(skillSetToAdd);
				ApplicationHelper.incrementSkillsetCount(skillSetToAdd);
			default:
				System.out.println("Hit the default. Just exiting.");
				break;
			}
			
			return true;
		}
		
		else {
			System.out.println("Exiting");
		}
		
		return true;
	}
	
}
