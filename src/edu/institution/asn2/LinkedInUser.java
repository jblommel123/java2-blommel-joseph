package edu.institution.asn2;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Comparator;

public class LinkedInUser extends UserAccount implements Comparable<LinkedInUser> {
/**
	 * 
	 */
	private static final long serialVersionUID = 7923776203647316583L;
	//must implement serializable
	private String type;
	private Set<String> skillSet;
	private List<LinkedInUser> connections = new ArrayList<>();
	public LinkedInUser(String Username, String Password) {
		super(Username, Password);
	}

	public LinkedInUser() {
		super();
	}

	@Override
	
	public void setType(String Type) {
		this.type = Type;

	}
	/**
	* Returns the type of this LinkedIn user.
	*
	* 
	*/
	public String getType() {
		return type;
	}
	/**
	* Adds the supplied connection to the list of connections for this user.
	*
	* @param user the connection to add.
	* @throws LinkedInException thrown if the supplied user is already
	* connected to this user.
	*/
	public void addConnection(LinkedInUser user) throws LinkedInException{
		if (this.connections.contains(user)) {
			throw new LinkedInException("You are already connected with this user.");
		}
		
		else {
			connections.add(user);
		}
		
	}
	
	public void removeConnection(LinkedInUser user) throws LinkedInException{
		if (this.connections.contains(user)) {
			this.connections.remove(user);
		}
		else {	
			throw new LinkedInException("You are not connected with this user.");
		}
	}
	
	/**
	* Returns a list of users that are connected to this user.
	* @return the list or empty list if this user has no connections.
	*/
	public List<LinkedInUser> getConnections(){
		List<LinkedInUser> connectionsCopy = new ArrayList<>();
		if(this.connections.isEmpty()) {
			return connectionsCopy;
		}
		connectionsCopy.addAll(this.connections);
		return connectionsCopy;
	}

	@Override
	public int compareTo(LinkedInUser user) {
		
		if (user == null || this.getUsername() == null || user.getUsername() == null) {
			return -1;
		}
		int intToReturn = this.getUsername().compareToIgnoreCase(user.getUsername());
		
		return intToReturn;
	}
	
	/** Returns the skillsets. */
	public Set<String> getSkillsets(){
		return skillSet;
	}
	/** Adds the supplied skillset to this user. */
	public void addSkillset(String skillset) {
		if (this.skillSet.contains(skillset)) {
			System.out.println("You already have this skill");
		}
		else {
			System.out.println("Skill " + skillset + " added.");
			this.skillSet.add(skillset);
		}
		
	}
	/** Removes the supplied skillset from this user. */
	public void removeSkillset(String skillset) {
		
		if(this.skillSet.contains(skillset)){
			this.skillSet.remove(skillset);
		}
		
		else {
			System.out.println("Unable to remove a skillset you don't have.");
		}
		
	}
	
	
	
}
