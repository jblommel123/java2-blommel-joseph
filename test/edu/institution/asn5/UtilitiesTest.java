package edu.institution.asn5;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import edu.institution.actions.asn5.Utilities;
import edu.institution.asn2.LinkedInUser;

class UtilitiesTest {
	
	

	@Test
	void testLinearSearch() {
		LinkedInUser testOne = new LinkedInUser("testOne", "testOne");
		LinkedInUser testTwo = new LinkedInUser("testTwo", "testTwo");
		ArrayList<LinkedInUser> testUserList = new ArrayList<LinkedInUser>();
		testUserList.add(testOne);
		testUserList.add(testTwo);
		Utilities utilities = new Utilities();
		assertEquals(testOne, utilities.linearSearch(testUserList, testOne));
		
	}
	@Test
	void testLinearSearchIntegers() {
		Integer one = 1, two = 2, three = 3;
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(one);
		intList.add(two);
		intList.add(three);
		Utilities utilities = new Utilities();
		assertEquals(one, utilities.linearSearch(intList, one));
	}
	@Test
	void testLinearSearchStrings() {
		String oneString = "one", twoString = "two", threeString = "three";
		ArrayList<String> strings = new ArrayList<String>();
		strings.add(oneString);
		strings.add(twoString);
		strings.add(threeString);
		Utilities utilities = new Utilities();
		assertEquals(threeString, utilities.linearSearch(strings, threeString));
	}
	@Test
	void testRemoveDuplicatesIntegers() {
		Integer one = 1, two = 2, three = 3;
		ArrayList<Integer> intList = new ArrayList<Integer>();
		ArrayList<Integer> uniqueIntList = new ArrayList<Integer>();
		uniqueIntList.add(one);
		uniqueIntList.add(two);
		uniqueIntList.add(three);
		intList.add(one);
		intList.add(two);
		intList.add(three);
		intList.add(one);
		intList.add(two);
		intList.add(three);
		Utilities utilities = new Utilities();
		utilities.removeDuplicates(intList);
		assertEquals(uniqueIntList, intList);
	}
	@Test
	void testRemoveDuplicatesStrings() {
		String oneString = "one", twoString = "two", threeString = "three";
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<String> uniqueStrings = new ArrayList<String>();
		strings.add(oneString);
		strings.add(twoString);
		strings.add(threeString);
		strings.add(oneString);
		strings.add(twoString);
		strings.add(threeString);
		Utilities utilities = new Utilities();
		uniqueStrings.add(oneString);
		uniqueStrings.add(twoString);
		uniqueStrings.add(threeString);
		utilities.removeDuplicates(strings);
		assertEquals(uniqueStrings, strings);
		
	}
	
	
	
	@Test
	void testListIsEmptyLinearSearch() {
		ArrayList<LinkedInUser> testUserList = new ArrayList<LinkedInUser>();
		Utilities utilities = new Utilities();
		assertEquals(null, utilities.linearSearch(testUserList, new LinkedInUser()));
	}
	
	@Test
	void testListIsEmptyRemoveDuplicates() {
		ArrayList<LinkedInUser> testUserList = new ArrayList<LinkedInUser>();
		
		Utilities utilities = new Utilities();
		utilities.removeDuplicates(testUserList);
		ArrayList<LinkedInUser> otherList = new ArrayList<LinkedInUser>();
		assertEquals(otherList, testUserList);
	}

	

	@Test
	void testRemoveDuplicates() {
		
		LinkedInUser testOne = new LinkedInUser("testOne", "testOne");
		LinkedInUser testTwo = new LinkedInUser("testTwo", "testTwo");
		ArrayList<LinkedInUser> testUserList = new ArrayList<LinkedInUser>();
		ArrayList<LinkedInUser> uniqueList = new ArrayList<LinkedInUser>();
		testUserList.add(testOne);
		testUserList.add(testTwo);
		testUserList.add(testOne);
		testUserList.add(testTwo);
		testUserList.add(testOne);
		testUserList.add(testTwo);
		Utilities utilities = new Utilities();
		utilities.removeDuplicates(testUserList);
		assertEquals(uniqueList.containsAll(uniqueList), testUserList.containsAll(uniqueList));
	}

}
