using System;
using System.Collections.Generic;

namespace day1
{
    class Program
    {
        static void Main(string[] args)
        {
            //part 1
            // System.IO.StreamReader file = new System.IO.StreamReader(@"input.txt");
            // string line = "";
            // int sum = 0;
            // while((line = file.ReadLine()) != null) {
            //     int temp = Int32.Parse(line);
            //     sum += temp;
            // }
            // file.Close(); 
            // Console.WriteLine(sum);

            //part 2
            System.IO.StreamReader file = new System.IO.StreamReader(@"input.txt");
            string line = "";
            int sum = 0;
            Dictionary<int, int> frequencyTracker = new Dictionary<int, int>();
            List<int> frequencyChanges = new List<int>();
            while((line = file.ReadLine()) != null) {
                int temp = Int32.Parse(line);
                frequencyChanges.Add(temp);
                sum += temp;
                if(frequencyTracker.ContainsKey(sum)) {
                    break;
                } else {
                    frequencyTracker.Add(sum, sum);
                }
            }
            bool notFound = true;
            while(notFound) {
                foreach (int value in frequencyChanges) {
                    sum += value;
                    if(frequencyTracker.ContainsKey(sum)) {
                        notFound = false;
                        break;
                    } else {
                        frequencyTracker.Add(sum, sum);
                    }
                }
            }
            file.Close(); 
            Console.WriteLine(sum);
        }
    }
}
