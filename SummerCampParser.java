// Assignment #: 5
// Arizona State University - CSE205
//         Name: Valliappan Valliappan
//    StudentID: 1217365019
//      Lecture: (M.W.F 8:35 – 9:25am)
//  Description: This class is used only for the creation and use of one method which parses a String and creates an object
//					of the SummerCamp class using the attributes that it has parsed from the String.
public class SummerCampParser {
	public static SummerCamp parseStringToSummerCamp(String lineToParse) {
		String[] attributes = lineToParse.split(":");// A String array to store the individual attributes of a
														// particular object
		SummerCamp obj;
		if (attributes[0].equalsIgnoreCase("DebateCamp")) {// if it is a debate camp
			obj = new DebateCamp(attributes[1], attributes[2], Double.parseDouble(attributes[3]),
					Integer.parseInt(attributes[4]), Double.parseDouble(attributes[5]), attributes[6]);// assigning
																										// values
																										// through
																										// instantiation
		} else if (attributes[0].equalsIgnoreCase("MathCamp")) {// if it is math camp
			obj = new MathCamp(attributes[1], attributes[2], Double.parseDouble(attributes[3]),
					Integer.parseInt(attributes[4]), attributes[5]);// assigning values through instantiation
		} else {// if it is a robotics camp
			obj = new RoboticsCamp(attributes[1], attributes[2], Double.parseDouble(attributes[3]),
					Integer.parseInt(attributes[4]), Double.parseDouble(attributes[5]),
					Double.parseDouble(attributes[6]));// assigning values through instantiation
		}
		return obj;
	}
}
