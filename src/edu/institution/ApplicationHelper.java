/*
 Copyright (C) 2020. Doug Estep -- All Rights Reserved.
 Copyright Registration Number: TXU002159309.

 This file is part of the Tag My Code application.

 This application is protected under copyright laws and cannot be used, distributed, or copied without prior written
 consent from Doug Estep.  Unauthorized distribution or use is strictly prohibited and punishable by domestic and
 international law.

 Proprietary and confidential.
 */
package edu.institution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.institution.asn2.LinkedInUser;

/**
 * Contains static helper methods to aid with the command line user interface.
 */
public class ApplicationHelper {
	
	/**
	* I picked the hashmap so that I can store each skillset as a string and 
	*
	* 
	*/
	
	private static HashMap<String, Integer> usersSkillsets= new HashMap<String, Integer>();

	/**
	 * Displays the supplied message to the console.
	 * 
	 * @param message the message.
	 */
	public static void showMessage(String message) {
		System.out.println("\n" + message);
	}
	
	/**
	* Increments the number of users associated with the supplied skillset.
	* If this is the first occurrence of the supplied skillset, then add
	* the skillset to your collection and default the count to one.
	*
	* @param skillset the skillset to increment.
	*/
	public static void incrementSkillsetCount(String skillset) {
		
		if (usersSkillsets.containsKey(skillset)) {
			Integer numberToIncrement = usersSkillsets.get(skillset);
			numberToIncrement++;
			usersSkillsets.put(skillset, numberToIncrement);
		}
		else {
			System.out.println("Adding skillset " + skillset + " to HashMap.");
			usersSkillsets.put(skillset, 1);
			
		}
		
	}
	
	public static void decreaseSkillsetCount(String skillSet) {
		if (usersSkillsets.containsKey(skillSet) && usersSkillsets.get(skillSet) > 0) {
			Integer numberToIncrement = usersSkillsets.get(skillSet);
			numberToIncrement--;
			usersSkillsets.put(skillSet, numberToIncrement);
		}
		else if(usersSkillsets.get(skillSet) == 0) {
			System.out.println("Could not lower that skillset count because it doesn't exist or isn't associated with any user.");
		}
	}
	
	/**
	* Retrieves the number of users associated with the supplied skillset.
	* If the skillset is not in the collection, return -1.
	*
	* @param skillset the skillset to lookup.
	*/
	public static int retrieveSkillsetCount(String skillset) {
		if (usersSkillsets.containsKey(skillset)) {
			return usersSkillsets.get(skillset);
		} else {
			System.out.println("This skillset doesn't exist. Returning -1");
			return -1;
		}
	}
	
	/**
	* Loops through each user and increments the global skillset usage count for
	* each skillset associated with the user.
	*
	* @param users the list of users.
	*/
	public static void initSkillsetUsages(List<LinkedInUser> users) {
		
		for (LinkedInUser linkedInUser : users) {
			HashSet<String> userskillset = (HashSet<String>) linkedInUser.getSkillSet();
			
			if (userskillset == null) {
				continue;
			}
			
			if(userskillset.isEmpty()) {
				continue;
			}
			for (String skillString : userskillset)
			{
				incrementSkillsetCount(skillString);
			}
		}
		
	}
	

	
	
}
