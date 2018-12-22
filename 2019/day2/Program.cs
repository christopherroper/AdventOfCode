using System;
using System.Collections.Generic;

namespace day2
{
    class Program
    {
        static void Main(string[] args)
        {
            // part 1
            // System.IO.StreamReader file = new System.IO.StreamReader(@"input.txt");
            // string line = "";
            // int twosCount = 0;
            // int threesCount = 0;
            
            // while((line = file.ReadLine()) != null) {
            //     Dictionary<char, int> charCounts = new Dictionary<char, int>();
            //     foreach(char c in line) {
            //         if(charCounts.ContainsKey(c)) {
            //             int currentCount = charCounts[c];
            //             currentCount++;
            //             charCounts[c] = currentCount;
            //         } else {
            //             charCounts[c] = 1;
            //         }
            //     }
            //     bool foundTwo = false;
            //     bool foundThree = false;
            //     foreach(KeyValuePair<char, int> entry in charCounts) {
            //         if(!foundTwo) {
            //             if(entry.Value == 2) {
            //                 foundTwo = true;
            //                 twosCount++;
            //                 continue;
            //             }
            //         }
            //         if(!foundThree) {
            //             if(entry.Value == 3) {
            //                 foundThree = true;
            //                 threesCount++;
            //                 continue;
            //             }
            //         }
            //         if(foundTwo && foundThree) {
            //             break;
            //         }
            //     }
            // }
            // Console.WriteLine(twosCount * threesCount);

            //part 2
            System.IO.StreamReader file = new System.IO.StreamReader(@"input.txt");
            string line = "";
            List<string> allLines = new List<string>();
            
            while((line = file.ReadLine()) != null) {
                allLines.Add(line);
            }
            Console.WriteLine(allLines.Count);
            Console.WriteLine(allLines[0].Length);
            for(int i = 0; i < allLines.Count - 1; i++) {
                for(int j = i + 1; j < allLines.Count - 2; j++) {
                    int errorCount = 0;
                    int index = 0;
                    for(int k = 0; k < allLines[i].Length; k++) {
                        if(allLines[i][k] != allLines[j][k]) {
                            errorCount++;
                            index = k;
                        }
                        if(errorCount > 1) {
                            break;
                        }
                    }
                    if(errorCount == 1) {
                        Console.WriteLine(allLines[i]);
                        Console.WriteLine(allLines[j]);
                        string removed = allLines[i].Remove(index, 1);
                        Console.WriteLine(removed);
                    }
                }
            }
        }
    }
}
