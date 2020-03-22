// Assignment #: 5
// Arizona State University - CSE205
//         Name: Valliappan Valliappan
//    StudentID: 1217365019
//      Lecture: (M.W.F 8:35 – 9:25am)
//  Description: This class is a representation of the robotics camps that take place in the summer.
//					It inherits from the SummerCamp class and implements the abstract method in its superclass.
import java.text.DecimalFormat;

public class RoboticsCamp extends SummerCamp {
	private double facilityFee, competitionFee;//facility and competition costs

	public RoboticsCamp(String title, String location, double rate, int weeks, double facilityFee, double compFee) {
		super(title, location, rate, weeks);//reusing code through inheritance
		this.facilityFee = facilityFee;
		this.competitionFee = compFee;
	}

	@Override
	public void computeTotalCosts() {
		totalCost = (weeklyRate * numberOfWeeks) + competitionFee + facilityFee;
	}

	public String toString() {
		DecimalFormat dollars = new DecimalFormat("$0.00");// DecimalFormat representing the format of two decimal
		// places after the dollar value to represent the number of cents
		return "\nRobotics Camp:" + super.toString() + "Facility Fee:\t\t" + dollars.format(facilityFee)
				+ "\nCompetition Fee:\t" + dollars.format(competitionFee) + "\n\n";
	}
}
