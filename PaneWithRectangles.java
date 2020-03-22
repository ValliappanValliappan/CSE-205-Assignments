// Arizona State University - CSE205
//         Name: Valliappan Valliappan
//    StudentID: 1217365019
//      Lecture: (M.W.F 8:35 – 9:25am)
//  Description: The Assignment 7 class display a menu of color choices
//               to a user
//               and performs the color change of a give grid that the assignment requires. Everytime,
//				 a dragging of the mouse happens, this functionality is activated. The handler is used.

//import any classes necessary here
//----
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class PaneWithRectangles extends BorderPane {
	private ComboBox<String> primaryColorCombo;// the list of primary colors
	private ComboBox<String> backColorCombo;// the list of background colors
	private ComboBox<String> widthCombo;// the list of widths that the stroke could be

	private Color primaryColor, secondaryColor, backgroundColor;// the different colors that are selected for primary,
																// secondary, background.
	private double selectWidth;// the currently selected width
	private final float rectWidth = 470 / 7;// the width of rectangle
	private final float rectHeight = 390 / 7;// the height of rectangle
	private Label primary, background, width;// the labels for the combo boxes
	private int lastRow = -1, lastColumn = -1;// beginning values that avoid color on the grid when it is not needed.

	private Rectangle[][] rectArray;// array of rectangles in the grid

	public PaneWithRectangles() {
		primaryColor = Color.BLACK;// setting default to black
		secondaryColor = Color.GRAY;// setting default to gray
		backgroundColor = Color.WHITE;// setting white as default
		selectWidth = 1.0;// setting 1.0 for the initially.

		// Instantiate and initialize labels, combo boxes
		primaryColorCombo = new ComboBox<String>();
		primaryColorCombo.getItems().addAll("Black", "Blue", "Red", "Green");
		primaryColorCombo.setValue("Black");// Initial value

		backColorCombo = new ComboBox<String>();
		backColorCombo.getItems().addAll("White", "Yellow", "Orange");
		backColorCombo.setValue("White");// Initial value

		widthCombo = new ComboBox<String>();
		widthCombo.getItems().addAll("1", "3", "5", "7");
		widthCombo.setValue("1");// Initial value

		primary = new Label("PrimaryColor");
		background = new Label("BackgroundColor");
		width = new Label("StrokeWidth");// Initial value

		rectArray = new Rectangle[7][7];// an empty array with 49 elements 7x7

		// Instantiate and initialize the two dimensional array rectArray
		// to contain 7 columns and 7 rows (49 rectangles total)
		// It is recommended to use nested loops

		// grid is a GridPane containing 49 rectangles.
		GridPane grid = new GridPane();
		// ---- add 49 rectangles to the grid pane, it is recommended to use nested
		// loops
		// ----
		// ----

		// leftPane is a VBox, it should contain labels and combo boxes
		VBox leftPane = new VBox();
		leftPane.getChildren().add(primary);// corresponding label
		leftPane.getChildren().add(primaryColorCombo);// combo box

		leftPane.getChildren().add(background);// label
		leftPane.getChildren().add(backColorCombo);// corresponding combo box

		leftPane.getChildren().add(width);// label
		leftPane.getChildren().add(widthCombo);// corresponding combo box

		for (int i = 0; i < 7; i++) {// iterating through rows
			for (int j = 0; j < 7; j++) {// iterating through the columns
				Rectangle rect = new Rectangle(0, 0, rectWidth, rectHeight);
				rectArray[i][j] = rect;// adding rectangle to array
				grid.add(rect, j, i);// adding to grid
				rect.setStroke(Color.BLACK);// initial stroke
				rect.setFill(Color.WHITE);// initial fill

			}
		}

		leftPane.setSpacing(0);
		leftPane.setPadding(new Insets(10, 0, 10, 0));

		// add the left pane to the left of the pane
		// and the grid pane contains rectangles at the center
		this.setLeft(leftPane);
		this.setCenter(grid);
		grid.setHgap(1);
		grid.setVgap(1);
		// registering/linking the source nodes with its handler objects such as the
		// grid and combo boxes
		grid.setOnMouseDragged(new MouseHandler());// when dragged
		widthCombo.setOnAction(new WidthHandler());// when value changes
		primaryColorCombo.setOnAction(new PrimColorHandler());// when value changes
		backColorCombo.setOnAction(new BackColorHandler());// when value changes

	}

	private void changePrimSecoColors(int row, int column) {
		try {
			rectArray[row][column].setFill(primaryColor);// the cell at the center of the drag
			if (row > 0) {
				rectArray[row - 1][column].setFill(secondaryColor);// above the center
			}
			if (row < 6) {
				rectArray[row + 1][column].setFill(secondaryColor);// below the center
			}
			if (column > 0) {
				rectArray[row][column - 1].setFill(secondaryColor);// to the left of center
			}
			if (column < 6) {
				rectArray[row][column + 1].setFill(secondaryColor);// to the right of center
			}
		} catch (ArrayIndexOutOfBoundsException e) {// handling for the unnecessary array bounds exception
			// No reaction since the only way it gets here is if the mouse is dragged
			// outside the grid
		}
	}

	// Step #2(A) - MouseHandler
	private class MouseHandler implements EventHandler<MouseEvent> {
		public void handle(MouseEvent event) {
			// handle MouseEvent here
			// Note: you can use if(event.getEventType()== MouseEvent.MOUSE_DRAGGED)
			// to check whether the mouse key is dragged
			// write your own codes here
			// ----
			if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
				double x = event.getX();// getting coordinates
				double y = event.getY();
				int row = (int) (y / rectHeight);// recognizing the row
				int column = (int) (x / rectWidth);// recognizing the column
				lastRow = row;// setting the last row and the last column
				lastColumn = column;
				for (int i = 0; i < 7; i++) {// iteration through rows
					for (int j = 0; j < 7; j++) {// column iteration
						rectArray[i][j].setFill(backgroundColor);// all cells are set to backGroundColors
					}
				}
				changePrimSecoColors(row, column);// sets the primary and secondary colors
			}

		}// end handle()

	}// end MouseHandler

	// A handler class used to handle primary and secondary colors
	private class PrimColorHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			// write your own codes here
			// ----
			String primary = primaryColorCombo.getValue();
			if (primary.equals("Black")) {// if black is selected
				primaryColor = Color.BLACK;
				secondaryColor = Color.GRAY;
			} else if (primary.equals("Blue")) {// if blue is selected
				primaryColor = Color.BLUE;
				secondaryColor = Color.POWDERBLUE;
			} else if (primary.equals("Red")) {// if red is selected
				primaryColor = Color.RED;
				secondaryColor = Color.PINK;
			} else if (primary.equals("Green")) {// if green is selected
				primaryColor = Color.GREEN;
				secondaryColor = Color.LIGHTGREEN;
			}
			if (lastRow != -1 && lastColumn != -1) {// if this is not the first ever cell that is selected
				changePrimSecoColors(lastRow, lastColumn);// set primary and secondary colors
			}
		}
	}// end PrimColorHandler

	// A handler class used to handle background color
	private class BackColorHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			// write your own codes here
			// ----
			String back = backColorCombo.getValue();
			if (back.equals("White")) {// it white is selected
				backgroundColor = Color.WHITE;
			} else if (back.equals("Yellow")) {
				backgroundColor = Color.YELLOW;// if yellow is selected
			} else if (back.equals("Orange")) {
				backgroundColor = Color.ORANGE;// if orange is selected
			}
			for (int i = 0; i < 7; i++) {// iterate through rows
				for (int j = 0; j < 7; j++) {// through columns
					rectArray[i][j].setFill(backgroundColor);// setting background
				}
			}
			changePrimSecoColors(lastRow, lastColumn);// replacing colors that get occupied by background
		}
	}// end BackColorHandler

	// A handler class used to handle stroke width
	private class WidthHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			// write your own codes here
			// ----
			String widthSelected = widthCombo.getValue();
			if (widthSelected.equals("1")) {// if width is selected as 1
				selectWidth = 1.0;
			} else if (widthSelected.equals("3")) {// if 3 is selected
				selectWidth = 3.0;
			} else if (widthSelected.equals("5")) {// if 5 is selected
				selectWidth = 5.0;
			} else if (widthSelected.equals("7")) {// if 7 is selected
				selectWidth = 7.0;
			}
			for (int i = 0; i < 7; i++) {// setting stroke width for every single cell in the grid
				for (int j = 0; j < 7; j++) {
					rectArray[i][j].setStrokeWidth(selectWidth);
				}
			}
		}
	}// end WidthHandler
} // end of PaneWithRectangles