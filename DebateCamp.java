// Assignment #: 5
// Arizona State University - CSE205
//         Name: Valliappan Valliappan
//    StudentID: 1217365019
//      Lecture: (M.W.F 8:35 – 9:25am)
//  Description: This class is a representation of the debate camps that take place in the summer.
//					It inherits from the SummerCamp class and implements the abstract method in its superclass.
import java.text.DecimalFormat;

public class DebateCamp extends SummerCamp {
	private boolean groupDiscount;// does a group discount exist
	private double materialFee;// the cost of materials

	public DebateCamp(String title, String location, double rate, int weeks, double materialFee, String discount) {
		super(title, location, rate, weeks);// reusing code through inheritance
		this.materialFee = materialFee;
		if (discount.equals("yes")) {// if there is a group discount, groupDiscount is set to true
			this.groupDiscount = true;
		} else if (discount.equals("no")) {// no group discount means groupDiscount is sent to false
			this.groupDiscount = false;
		}
	}

	public void computeTotalCosts() {
		totalCost = (groupDiscount) ? (0.9 * weeklyRate * numberOfWeeks) : (weeklyRate * numberOfWeeks);
		totalCost += materialFee;// material fee is added to the total cost.
	}

	public String toString() {// The String representation of a DebateCamp object
		DecimalFormat dollars = new DecimalFormat("$0.00");// DecimalFormat representing the format of two decimal
		// places after the dollar value to represent the number of cents
		return "\nDebate Camp:" + super.toString() + "Material Fee:\t\t" + dollars.format(materialFee)
				+ "\nGroup Discount:\t\t" + (groupDiscount ? "yes" : "no") + "\n\n";
	}
}
