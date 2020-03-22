// Assignment #: 5
// Arizona State University - CSE205
//         Name: Valliappan Valliappan
//    StudentID: 1217365019
//      Lecture: (M.W.F 8:35 – 9:25am)
//  Description: This class is an abstract class which is a representation of camps that take place during the summer
//				Also, this class has three separate subclasses under it.
import java.text.DecimalFormat;

public abstract class SummerCamp {
	protected String title, location;// title and location of the SummerCamp
	protected double weeklyRate, totalCost;// the cost per week and the total cost over the course of the camp
	protected int numberOfWeeks;// number of weeks of the camp in the summer

	public SummerCamp(String someTitle, String someLocation, double someWeeklyRate, int someNumberOfWeeks) {// initializing
																											// instance
																											// variables
		totalCost = 0.0;
		title = someTitle;
		location = someLocation;
		weeklyRate = someWeeklyRate;
		numberOfWeeks = someNumberOfWeeks;
	}

	public String getCampTitle() {// Accessor for the title of the summer camp
		return title;
	}

	public abstract void computeTotalCosts();// an abstract method to be implemented in subclasses of SummerCamp to
												// calculate total costs.

	public String toString() {// the String representation of a SummerCamp object
		DecimalFormat dollars = new DecimalFormat("$0.00");// DecimalFormat representing the format of two decimal
		// places after the dollar value to represent the number of cents
		return "\nCamp Title:\t\t" + title + "\nLocation:\t\t" + location + "\nWeekly Rate:\t\t"
				+ dollars.format(weeklyRate) + "\nWeeks:\t\t\t" + numberOfWeeks + "\nTotal Cost:\t\t"
				+ dollars.format(totalCost) + "\n";
	}
}
