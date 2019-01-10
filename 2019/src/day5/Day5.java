package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File inputFile = new File("src/day5/input.txt");
		Scanner inputScanner = new Scanner(inputFile);
		String inputString = inputScanner.nextLine();
		inputScanner.close();
		int shortestLength = Integer.MAX_VALUE;
		for(int i = 65; i < 91; i++) {
			String reducedPolymer = recursiveHelper(inputString, true, i);
			shortestLength = Math.min(shortestLength, reducedPolymer.length());
		}
		
//		System.out.println(reducedPolymer.length());
		System.out.println(shortestLength);
	}
	
	public static String recursiveHelper(String polymer, Boolean foundReaction, int testChar) {
		
		if(!foundReaction) {
			return polymer;
		}
		
		foundReaction = false;
		StringBuilder reduced = new StringBuilder();
		
		for(int i = 0; i < polymer.length() - 1; i++) {

			if(polymer.charAt(i) == testChar || polymer.charAt(i) == testChar + 32) {
				continue;
			}
			
			if(polymer.charAt(i) == polymer.charAt(i+1) + 32 || polymer.charAt(i) == polymer.charAt(i+1) - 32) {
				foundReaction = true;
				i++;
			} else {
				reduced.append(polymer.charAt(i));
			}
			
			if(i == polymer.length() - 2) {
				reduced.append(polymer.charAt(i));
			}
		}
		
		return recursiveHelper(reduced.toString(), foundReaction, testChar);
	}

}
