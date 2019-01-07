package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Day4 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File inputFile = new File("src/day4/input.txt"); 
	    Scanner inputScanner = new Scanner(inputFile);
	    ArrayList<String> logs = new ArrayList<>();
	    
	    HashMap<String, Guard> guards = new HashMap<>();
	    
	    while(inputScanner.hasNextLine()) {
	    	logs.add(inputScanner.nextLine());
	    }
	    
	    inputScanner.close();
	    
	    Collections.sort(logs);
	    
	    String sleepiestGuardID = "";
	    int sleepiestGuardTotalSleepTime = 0;
	    
	    int currentShiftFellAsleepTime = 0;
	    String guardID = "";

	    for(String s : logs) {
	    	String [] parsed = s.split(" ");
	    	String [] timeString = parsed[1].split(":");
	    	int time = Integer.parseInt(timeString[1].substring(0, 2));
	    	if(parsed[2].equals("Guard")) {
	    		guardID = parsed[3].replace("#", "");
	    		//new guard on duty
	    		if(!guards.containsKey(guardID)) {
    				guards.put(guardID, new Guard(guardID));
    			}
	    	}
	    	else if(parsed[2].equals("falls")) {
	    		currentShiftFellAsleepTime = time;
	    	} else {
	    		guards.get(guardID).totalSleepTime += time - currentShiftFellAsleepTime;
	    		if(guards.get(guardID).totalSleepTime > sleepiestGuardTotalSleepTime) {
	    			sleepiestGuardTotalSleepTime = guards.get(guardID).totalSleepTime;
	    			sleepiestGuardID = guardID;
	    		}

	    		for(int i = currentShiftFellAsleepTime; i < time; i++) {
	    			if(guards.get(guardID).minuteCounts.containsKey(i)) {
	    				int minuteCount = guards.get(guardID).minuteCounts.get(i);
	    				guards.get(guardID).minuteCounts.replace(i, minuteCount + 1);
	    			} else {
	    				guards.get(guardID).minuteCounts.put(i, 1);
	    			}
	    		}		
	    	}
	    }
	    
	    System.out.println("sleepiest guard:");
	    System.out.println(sleepiestGuardID);
//	    System.out.println(sleepiestGuardTotalSleepTime);
	    int sleepiestTime = 0;
	    int sleepiestTimeCount = 0;
	    Guard sleepiestGuard = guards.get(sleepiestGuardID);
	    for(Entry<Integer, Integer> e : sleepiestGuard.minuteCounts.entrySet()) {
	    	if(e.getValue() > sleepiestTimeCount) {
	    		sleepiestTime = e.getKey();
	    		sleepiestTimeCount = e.getValue();
	    	}
	    }
	    System.out.println("sleepiest time:");
	    System.out.println(sleepiestTime);
//	    System.out.println(sleepiestTimeCount);
	}
}
