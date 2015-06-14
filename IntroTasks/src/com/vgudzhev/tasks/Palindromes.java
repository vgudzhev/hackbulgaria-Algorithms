package com.vgudzhev.tasks;

import java.util.ArrayList;
import java.util.List;

public class Palindromes {
	
	public static String solve(String input) {
		if (input.length() == 1) {
			return input;
		} else{
			List<String> palindromeCandidates = generateAllRotations(input);
			
			for(String palindromeCandidate : palindromeCandidates){
				boolean isPalindrome = palindromeCheck(palindromeCandidate); 
				if (isPalindrome) {
					return palindromeCandidate;
				}
			}
			
			return "NONE";			
		}
	}
	
	public static List<String> generateAllRotations(String input){
		List<String> rotationCombinations = new ArrayList<String>();
		String currentWord = input;
		for (int i = 0; i < input.length(); i++) {
			currentWord = currentWord.substring(1) + currentWord.charAt(0);
			rotationCombinations.add(currentWord);
		}
		
		return rotationCombinations;
	}
	
	public static boolean palindromeCheck(String palindromeCandidate){
		int leftIndex = 0;
		int rightIndex = palindromeCandidate.length()-1;
		
		while (rightIndex > leftIndex) {
			if (palindromeCandidate.charAt(leftIndex) != palindromeCandidate.charAt(rightIndex)) {
				return false;
			}
			++leftIndex;
			--rightIndex;
		}
		return true;
	}
}
