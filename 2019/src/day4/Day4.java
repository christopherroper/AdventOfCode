package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Day4 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File inputFile = new File("src/day4/input.txt"); 
	    Scanner inputScanner = new Scanner(inputFile);
	    ArrayList<String> logs = new ArrayList<>();
	    HashMap<String, Integer> guardSleepTime = new HashMap<>();
	    HashMap<String, HashMap<Integer, Integer>> guardMinuteCounts = new HashMap<>();
	    while(inputScanner.hasNextLine()) {
	    	logs.add(inputScanner.nextLine());
	    }
	    Collections.sort(logs);
	    
	    String currentGuard = "";
	    int currentGuardSleepTime = 0;
	    for(String s : logs) {
	    	String [] parsed = s.split(" ");
	    	String [] time = parsed[1].split(":");
	    	if(parsed[2].equals("Guard")) {
	    		currentGuard = parsed[3].replace("#", "");
	    	}
	    	
	    	System.out.println(s);
	    }
	}

}
