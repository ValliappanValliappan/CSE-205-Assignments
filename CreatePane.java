
//Assignment #: 6
//Arizona State University - CSE205
//      Name: Valliappan Valliappan
// StudentID: 1217365019
//   Lecture: (M.W.F 8:35 – 9:25am)
//  Description: CreatePane generates a pane where a user can enter
//  a club information and create a list of available clubs.

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import
import javafx.geometry.Insets;
import javafx.geometry.Pos;

//import all other necessary javafx classes here
//----

public class CreatePane extends HBox {
	ArrayList<Club> clubList;// Stores all clubs that are created

	// The relationship between CreatePane and SelectPane is Aggregation
	private SelectPane selectPane;
	private GridPane grid;
	private VBox vertical;
	private BorderPane buttonPane;//only for the button
	
	private TextArea display;// displays created clubs
	private Label errorDisplay;// displays errors and suggestions
	private Button clubCreate;// creates a club with its handler
	private Label title;// title of the club
	private Label numOfMembers;// num of club members
	private Label university;// university where the club is set up
	private TextField titleText;
	private TextField numText;
	private TextField universityText;
	

	// constructor
	public CreatePane(ArrayList<Club> list, SelectPane sePane) {
		this.clubList = list;
		this.selectPane = sePane;

		// initializing each instance variable (textfields, labels, textarea, button,
		// etc.)
		// ----
		errorDisplay = new Label("");
		display = new TextArea("");
		title = new Label("Title");
		numOfMembers = new Label("Number of Members");
		university = new Label("University");
		titleText = new TextField();
		numText = new TextField();
		universityText = new TextField();
		clubCreate = new Button("Create a Club");
		// creating a GridPane hold those labels & text fields.
		// you can choose to use .setPadding() or setHgap(), setVgap()
		// to control the spacing and gap, etc.
		// ----
		grid = new GridPane();//creating the grid pane and initializing
		grid.setHgap(10);//setting horizontal gap
		grid.setVgap(20);//setting vertical gap
		grid.setPadding(new Insets(20, 20, 20, 20));//setting an inset for the padding
		//adding the labels to the first column which is referred to as column 0
		grid.add(title, 0, 0);
		grid.add(numOfMembers, 0, 1);
		grid.add(university, 0, 2);
		//adding the textfields of the corresponding labels in the same row but the next column
		grid.add(titleText, 1, 0);
		grid.add(numText, 1, 1);
		grid.add(universityText, 1, 2);

		// Setting up the layout
		vertical = new VBox();//creating, initializing a vbox for gridpane and button.
		vertical.getChildren().add(errorDisplay);
		vertical.getChildren().add(grid);
		
		
		buttonPane = new BorderPane();//a pane separately for the button
		buttonPane.setCenter(clubCreate);//center of the pane is the button
		vertical.getChildren().add(buttonPane);//the button is now in the vbox

		// Setting up the layout for the left half of the CreatePane.
		// ----
		this.getChildren().add(vertical);// the left of the createpane
		this.getChildren().add(display);// the right of the createpane

		// registering/linking source object with event handler
		// ----
		ButtonHandler clubCreateHandler = new ButtonHandler();//handler for creating a club
		clubCreate.setOnAction(clubCreateHandler);//registration

	} // end of constructor

	// Create a ButtonHandler class
	// ButtonHandler listens to see if the button "Create" is pushed or not,
	// When the event occurs, it get a club's Title, its number of members, and its
	// university
	// information from the relevant text fields, then create a new club and add it
	// inside
	// the clubList. Meanwhile it will display the club's information inside the
	// text area.
	// using the toString method of the Club class.
	// It also does error checking in case any of the textfields are empty,
	// or a non-numeric value was entered for its number of members
	private class ButtonHandler implements EventHandler<ActionEvent> {
		// Override the abstact method handle()
		public void handle(ActionEvent event) {
			// declare any necessary local variables here
			// ---
			errorDisplay.setTextFill(Color.RED);//setting the error field to red text color
			// when a text field is empty and the button is pushed
			if (titleText.getText().equals("") || numText.getText().equals("") || universityText.getText().equals("")) {
				errorDisplay.setText("Please fill all fields");
			} else // for all other cases
			{
				// when a non-numeric value was entered for its number of members
				// and the button is pushed
				// you will need to use try & catch block to catch
				// the NumberFormatException
				// ----
				try {
					Integer.parseInt(numText.getText());
				} catch (NumberFormatException e) {
					errorDisplay.setText("Please enter an integer for a number of members.");
				}
				// When a club of an existing club name in the list
				// was attempted to be added, do not add it to the list
				// and displaying a message "Club not added - duplicate"
				int duplicate = 0;//flag variable for duplicity
				for (Club club : clubList) {//iterating through the clubList
					if (club.getClubName().equals(titleText.getText())) {//if the club already exists
						errorDisplay.setText("Club not added - duplicate");//display message in RED
						duplicate = 1;//set duplicitiy
					}
				}
				// at the end, updating the new arrayList
				// information on the SelectPanel
				// ----
				if (duplicate == 0) {
					//Creating the Club object that has been added by create button
					Club newClub = new Club();
					newClub.setClubName(titleText.getText());
					newClub.setNumberOfMembers(Integer.parseInt(numText.getText()));
					newClub.setUniversity(universityText.getText());
					
					selectPane.updateClubList(newClub);//updating clubList
					display.setText(display.getText() + newClub.toString());//adding the newClub to existing clubs
					errorDisplay.setText("Club added");//display response
					
					// Resetting the text fields
					titleText.setText("");
					numText.setText("");
					universityText.setText("");
				}

				

			}

		} // end of handle() method
	} // end of ButtonHandler class

}
