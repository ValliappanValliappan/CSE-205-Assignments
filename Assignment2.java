// Assignment #: 1
// Arizona State University - CSE205
//         Name: Valliappan Valliappan
//    StudentID: 1217365019
//      Lecture: (M.W.F 8:35 – 9:25am)
//  Description: This class reads in an unspecified number of integers from standard input, 
//				 performs some calculations on the input numbers, and outputs the results of 
//				 those calculations to standard output.

import java.util.Scanner;

public class Assignment2 {
	public static void main(String args[]) {
		Scanner inputGetter = new Scanner(System.in);
		int smallest = 0, largestEven = 0, oddCount = 0, sumPositive = 0;
		for (;;) {
			int num = inputGetter.nextInt();
			smallest = (num < smallest) ? num : smallest;// if num is smaller than smallest, it becomes smallest
			if (num % 2 == 0) {
				// if num is greater than largestEven,it becomes largestEven
				largestEven = (num > largestEven) ? num : largestEven;
			} else {// num must be odd if it is not even
				oddCount++;
			}
			if (num > 0) {
				sumPositive += num;
			}
			if (num == 0) {// if num==0, then the loop must end according to assignment instructions
				break;
			}
		}
		System.out.println("The minimum integer is " + smallest);
		System.out.println("The count of odd integers in the sequence is " + oddCount);
		System.out.println("The largest even integer in the sequence is " + largestEven);
		System.out.print("The sum of positive integers is " + sumPositive);
	}
	
}
