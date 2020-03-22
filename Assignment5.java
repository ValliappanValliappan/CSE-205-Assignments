// Assignment #: 6
// Arizona State University - CSE205
//         Name: Valliappan Valliappan
//    StudentID: 1217365019
//      Lecture: (M.W.F 8:35 – 9:25am)
//  Description: The Assignment 5 class displa ys a menu of choices
//               (add summer camp, search summer camp title,
//               list summer camps, quit, display menu) to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*; //to use InputStreamReader and BufferedReader
import java.util.*; //to use ArrayList

public class Assignment5 {
	public static void main(String[] args) {
		String x1 = "CSE905";

		String x2 = "DSE100";

		int result = x1.compareTo(x2);
		System.out.print(result);
	}
	public static void main1(String[] args) {
		char input1;
		String inputInfo = new String();
		String line = new String();
		boolean operation;

		// ArrayList object is used to store SummerCamp objects
		ArrayList<SummerCamp> summerCampList = new ArrayList<SummerCamp>();

		try {
			printMenu(); // print out menu

			// create a BufferedReader object to read input from a keyboard
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader stdin = new BufferedReader(isr);

			do {
				System.out.println("What action would you like to perform?");
				line = stdin.readLine().trim();
				input1 = line.charAt(0);
				input1 = Character.toUpperCase(input1);

				if (line.length() == 1) {
					switch (input1) {
					case 'A': // Add SummerCamp
						System.out.print("Please enter some summer camp information to add:\n");
						inputInfo = stdin.readLine().trim();
						SummerCamp object=SummerCampParser.parseStringToSummerCamp(inputInfo);//parsing a string to convert into a SummerCamp object.
						summerCampList.add(object);//adding the parsed SummerCamp object
						break;
					case 'C': // Compute Total Costs for all camps
						for(SummerCamp camp:summerCampList) {//Iterating through all of the elements of summerCampList
							camp.computeTotalCosts();//computing the totalCost of each camp in summerCampList
						}
						System.out.print("total costs computed\n");
						break;
					case 'D': // Search for SummerCamp
						System.out.print("Please enter a summer camp title to search:\n");
						inputInfo = stdin.readLine().trim();
						operation = false;
						for(SummerCamp camp:summerCampList) {//Iterating through all of the elements of summerCampList
							if(camp.title.equalsIgnoreCase(inputInfo)) {//if the title of an object matches
								operation=true;//operation is set to true
								break;
							}
						}
						if (operation == true)//If operation is true
							System.out.print("SummerCamp found\n");
						else//if operation is false
							System.out.print("SummerCamp not found\n");
						break;
					case 'L': // List SummerCamps
						if(summerCampList.size()!=0) {//if the summerCampList is not empty
						for(SummerCamp camp:summerCampList) {//Iterating through all elements of summerCampList
							System.out.print(camp);//print the String representation of the object camp
						}
						}
						else {//if the summerCampList is empty
							System.out.print("no summer camp\n");
						}
						break;
					case 'Q': // Quit
						break;
					case '?': // Display Menu
						printMenu();
						break;
					default:
						System.out.print("Unknown action\n");
						break;
					}
				} else {
					System.out.print("Unknown action\n");
				}
			} while (input1 != 'Q'); // stop the loop when Q is read
		} catch (IOException exception) {
			System.out.println("IO Exception");
		}
	}

	/** The method printMenu displays the menu to a user **/
	public static void printMenu() {
		System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "A\t\tAdd SummerCamp\n"
				+ "C\t\tCompute Total Costs\n" + "D\t\tSearch for SummerCamp\n" + "L\t\tList SummerCamps\n"
				+ "Q\t\tQuit\n" + "?\t\tDisplay Help\n\n");
	}
}
