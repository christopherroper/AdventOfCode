package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day3 {

  public static void main(String[] args) throws FileNotFoundException {
    int [][] grid = new int [1000][1000];
    
    File inputFile = new File("src/day3/input.txt"); 
    Scanner inputScanner = new Scanner(inputFile);
    HashMap<String, String> gridOverlays = new HashMap<>();
    ArrayList<String> potentialClaims = new ArrayList<>();
    int overlapCount = 0;
    
      while (inputScanner.hasNextLine()) {
        String inputString = inputScanner.nextLine();
        String [] splitString = inputString.split(" ");
        String [] startingPoints = splitString[2].split(",");
        
        int xStartingPoint = Integer.parseInt(startingPoints[0]);
        int yStartingPoint = Integer.parseInt(startingPoints[1].substring(0, startingPoints[1].length() - 1));
        
        String [] dimensions = splitString[3].split("x");
        int xLength = Integer.parseInt(dimensions[0]);
        int yLength = Integer.parseInt(dimensions[1]);
        Boolean potentialCandidate = true;
        for(int x = xStartingPoint; x < xStartingPoint + xLength; x++) {
          for(int y = yStartingPoint; y < yStartingPoint + yLength; y++) {
            //
            if(gridOverlays.containsKey(x + "," + y)) {
              potentialClaims.remove(gridOverlays.get(x + "," + y));
              potentialCandidate = false;
            } else {
              gridOverlays.put(x + "," + y, splitString[0]);
            }
            if(grid[x][y] == 1) {
              overlapCount++;
            }
            grid[x][y]++;
          }
        }
        if(potentialCandidate) {
          potentialClaims.add(splitString[0]);
        }
      }
      inputScanner.close();
      for(String s : potentialClaims) {
        System.out.println(s);
      }
      System.out.println(overlapCount);
    }
}
