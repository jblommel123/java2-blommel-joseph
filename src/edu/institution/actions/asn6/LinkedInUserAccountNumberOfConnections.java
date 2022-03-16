package edu.institution.actions.asn6;

import java.util.ArrayList;
import java.util.Comparator;
import edu.institution.asn2.LinkedInUser;

public class LinkedInUserAccountNumberOfConnections implements Comparator<LinkedInUser> {

	@Override
	public int compare(LinkedInUser o1, LinkedInUser o2) {
		
		ArrayList<LinkedInUser> listOfConnectionsArrayList = (ArrayList<LinkedInUser>) o1.getConnections();
		
		int firstUserConnectionCount = listOfConnectionsArrayList.size();
		listOfConnectionsArrayList = (ArrayList<LinkedInUser>) o2.getConnections();
		int secondUserConnectionList = listOfConnectionsArrayList.size();
		
		return (firstUserConnectionCount == secondUserConnectionList) ? 0 : (firstUserConnectionCount > secondUserConnectionList) ? 1 : -1;
	}

}
