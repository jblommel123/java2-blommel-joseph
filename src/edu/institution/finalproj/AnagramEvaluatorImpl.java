package edu.institution.finalproj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AnagramEvaluatorImpl implements AnagramEvaluator {

	@Override
	public List<String> evaluate(String anagram, String option) {
		
		AnagramDataReaderImpl dataReaderImpl = new AnagramDataReaderImpl();
		ArrayList<String> returnList = new ArrayList<String>();
		char[] characters = anagram.toCharArray();
		permute(anagram, 0, characters.length - 1, returnList);
		
		if (option.equalsIgnoreCase("words")) {
			returnList = (ArrayList<String>) removeDuplicates(returnList);
			returnList = (ArrayList<String>) removeNonWordEntries(returnList);
		}
		
		else {
			returnList = (ArrayList<String>) removeDuplicates(returnList);
		}
		return returnList;
	}
	
	
	   //https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
		private static void permute(String str, int l, int r, ArrayList<String> listToPopulate)
		{
			if (l == r) {
				listToPopulate.add(str);
				//System.out.println(str);
			}
			else
			{
				for (int i = l; i <= r; i++)
				{
					str = swap(str,l,i);
					permute(str, l+1, r, listToPopulate);
					str = swap(str,l,i);
					
				}
			}
		}
		   
		   public static String swap(String a, int i , int j) {
			   char temp;
				char[] charArray = a.toCharArray();
				temp = charArray[i] ;
				charArray[i] = charArray[j];
				charArray[j] = temp;
				return String.valueOf(charArray);
		   }
		   
		   private static List<String> removeDuplicates(List<String> listTocheck) {
			   HashSet<String> uniqueWordsHashSet = new HashSet<String>(listTocheck);
			   ArrayList<String> uniqueWordsList = new ArrayList<String>(uniqueWordsHashSet);
			   return uniqueWordsList;
			   
		   }
		   
		   private static List<String> removeNonWordEntries(List<String> listToFilter) {
			   AnagramDataReaderImpl dataReaderImpl = new AnagramDataReaderImpl();
			   HashSet<String> webstersDictionaryHashSet = new HashSet(dataReaderImpl.readData());
			   ArrayList<String> uniqueWords = new ArrayList<String>();
			   for (String string : listToFilter) {
				if(webstersDictionaryHashSet.contains(string.toUpperCase())) {
					uniqueWords.add(string);
				}

			   }
			   
			   return uniqueWords;
		   }

}
