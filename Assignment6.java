
//Assignment #: 6
//Arizona State University - CSE205
//    Name: Valliappan Valliappan
//StudentID: 1217365019
// Lecture: (M.W.F 8:35 – 9:25am)
//  Description: The Assignment6 class creates a Tabbed Pane with
//               two tabs, one for Club Creation and one for
//               Club Selection.

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;

public class Assignment6 extends Application
{
	private TabPane tabPane;
	private CreatePane createPane;
	private SelectPane selectPane;
    private ArrayList<Club> clubList;

    public void start(Stage stage)
    {
 		StackPane root = new StackPane();

 		CircleColors cc=new CircleColors();

        root.getChildren().add(cc);

        Scene scene = new Scene(root, 900, 400);
        stage.setTitle("Bruh");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}