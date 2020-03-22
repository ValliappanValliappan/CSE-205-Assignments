// Assignment #: 4
// Arizona State University - CSE205
//         Name: Valliappan Valliappan
//    StudentID: 1217365019
//      Lecture: (M.W.F 8:35 – 9:25am)
//  Description: This class represents the president of a student club in a university and contains the methods that are required to access and mutate its instance variables
public class President {
	private String firstName, lastName, academicLevel;

	public President() { // Constructor for objects of the President class
		firstName = "?";
		lastName = "?";
		academicLevel = "?";
	}

	public String getFirstName() {// Accessor of first Name
		return firstName;
	}

	public String getLastName() {// Accessor of President's last name
		return lastName;
	}

	public String getAcademicLevel() {// Accessor of the academic level
		return academicLevel;
	}

	public void setFirstName(String someFirstName) {// Setter of President's first name
		firstName = someFirstName;
	}

	public void setLastName(String someLastName) {// Setter of President's last name
		lastName = someLastName;
	}

	public void setAcademicLevel(String someLevel) {// Setter of President's academic level
		academicLevel = someLevel;
	}

	public String toString() {// A string representation of an instance of the President class
		return lastName + "," + firstName + "(" + academicLevel + ")";
	}

}
