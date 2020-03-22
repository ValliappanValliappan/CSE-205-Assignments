import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleColors extends BorderPane{
	Color selectedColor;
	ComboBox<String> colors;
	Circle[] circles6;
	Pane pane;
	int RAD=40;
	public CircleColors() {
		colors = new ComboBox<String>();
		circles6=new Circle[6];
		colors.getItems().addAll("Red","Blue","Yellow","Green");
		colors.setValue("Red");
		pane = new Pane();
		
		Circle c1=new Circle(40, 100, RAD);
		Circle c2=new Circle(120, 100, RAD);
		Circle c3=new Circle(200, 100, RAD);
		Circle c4=new Circle(280, 100, RAD);
		Circle c5=new Circle(360, 100, RAD);
		Circle c6=new Circle(440, 100, RAD);
		circles6[0]=c1;
		circles6[1]=c2;
		circles6[2]=c3;
		circles6[3]=c4;
		circles6[4]=c5;
		circles6[5]=c6;
		
		this.getChildren().add(pane);
		pane.getChildren().add(colors);
		pane.getChildren().addAll(c1,c2,c3,c4,c5,c6);
		
		
		colors.setOnAction(new ColorHandler());
		
	}
	private class ColorHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			
		}
	}

}
