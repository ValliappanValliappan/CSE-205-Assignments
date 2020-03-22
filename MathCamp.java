// Assignment #: 5
// Arizona State University - CSE205
//         Name: Valliappan Valliappan
//    StudentID: 1217365019
//      Lecture: (M.W.F 8:35 – 9:25am)
//  Description: This class is a representation of the mathematics camps that take place in the summer.
//					It inherits from the SummerCamp class and implements the abstract method in its superclass.
public class MathCamp extends SummerCamp {// A class that represents a math camp that takes place during the summer.
	private boolean testTaking;// represents whether test taking is allowed in the particular Math Camp

	public MathCamp(String title, String location, double rate, int weeks, String testTaking) {
		super(title, location, rate, weeks);// reusing code through inheritance
		if (testTaking.equals("yes")) {// if the String is "yes", testTaking is set to true
			this.testTaking = true;
		} else if (testTaking.equals("no")) {// if the String is "no", testTaking is set to false
			this.testTaking = false;
		}
	}

	@Override
	public void computeTotalCosts() {// Overridden method used to compute the total cost of Math camp during the
										// summer
		totalCost = (weeklyRate * numberOfWeeks) + (testTaking ? 25.0 : 0.0);// the totalCost of Math Camp
	}

	public String toString() {// A String representation of the MathCamp object
		return "\nMath Camp:" + super.toString() + "Test Taking:\t\t" + (testTaking ? "yes" : "no") + "\n\n";// final toString
	}
}
