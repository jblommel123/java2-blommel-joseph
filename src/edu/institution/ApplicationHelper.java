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

import java.util.List;
import java.util.Set;

import edu.institution.asn2.LinkedInUser;

/**
 * Contains static helper methods to aid with the command line user interface.
 */
public class ApplicationHelper {
	
	

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
		
	}
	
	/**
	* Retrieves the number of users associated with the supplied skillset.
	* If the skillset is not in the collection, return -1.
	*
	* @param skillset the skillset to lookup.
	*/
	public static int retrieveSkillsetCount(String skillset) {
		return 0;
	}
	
	/**
	* Loops through each user and increments the global skillset usage count for
	* each skillset associated with the user.
	*
	* @param users the list of users.
	*/
	public static void initSkillsetUsages(List<LinkedInUser> users) {
		
	}
	
	
}
