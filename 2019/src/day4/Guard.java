package day4;

import java.util.HashMap;

public class Guard {

	public String ID;
	public int totalSleepTime;
	public HashMap<Integer, Integer> minuteCounts = new HashMap<>();
	
	public Guard(String id) {
		ID = id;
		totalSleepTime = 0;
	}
}
