package edu.institution.finalproj;

import java.util.List;

public interface AnagramEvaluator {
	/**
	* Returns a list of words derived from the supplied anagram.
	*
	* @param anagram the anagram to evaluate.
	* @param option the command line option. Values are �nf� or �words�. If null,
	* default to �words�.
	* @return the list of words derived from the supplied anagram.
	*/
	List<String> evaluate(String anagram, String option);
}
