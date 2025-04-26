// Purpose: 
//		Using JavaFX, this program displays a window and
// 		prompts the user to enter the order, and the 
//		corresponding Sierpinski triangle is drawn on the screen.
//		Recursion is used to implement this solution
// Programmer: Carl Ashie Nikoi
// Date: Sept 2024

// Required javafx libraries for this application
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class SierpinskiTriangle extends Application {
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) { 
		
		// Create a SierpinskiTriangle Pane
		SierpinskiTrianglePane trianglePane = new SierpinskiTrianglePane();
		
		// Define a text field and set up the event 
		// handler to set the order of the SierpinskiTriangle when
		// a value is typed into the field
		TextField tfOrder = new TextField(); 
		tfOrder.setOnAction(
				e -> trianglePane.setOrder(Integer.parseInt(tfOrder.getText())));
		tfOrder.setPrefColumnCount(4);
		tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

		// Define Horizontal box Pane to hold label and a text field
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
		hBox.setAlignment(Pos.CENTER);
    
		// Define a border pane to have two regions:
		// Center for drawing the triangle
		// Bottom for the label and the text field
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(trianglePane);
		borderPane.setBottom(hBox);
        
		// Create a scene and place the border pane in the stage
		Scene scene = new Scene(borderPane, 600, 610);
		primaryStage.setTitle("SierpinskiTriangle"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
    
		// Add a listener to repaint the scene if the window is resized
		scene.widthProperty().addListener(ov -> trianglePane.paint());
		scene.heightProperty().addListener(ov -> trianglePane.paint());
	}// start

	// SierpinskiTrianglePane
	//		Subclass of the Pane class.
	static class SierpinskiTrianglePane extends Pane {
		
		// data fields
		private int order = 0;

		//Method setOrder
		//		Set the order of the SierpinskiTriangle and
		//		if it is changed, repaint the triangle
		public void setOrder(int order) {
			this.order = order;
			paint();
		}//setOrder

		// Default constructor
		SierpinskiTrianglePane() {
		}

		// Method paint
		//		Draw the Sierpinski triangle
		protected void paint() {
			// Select three points in proportion to the pane size
			Point2D p1 = new Point2D(getWidth() / 2, 10);
			Point2D p2 = new Point2D(10, getHeight() - 10);
			Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);

			// Clear the pane before redisplay
			this.getChildren().clear(); 

			// Display the triangles with the given order
			displayTriangles(order, p1, p2, p3);
		}//paint

		// Method displayTriangles
		// 		Recursive method to draw the Sierpinski triangles
		private void displayTriangles(int order, Point2D p1, 
										Point2D p2, Point2D p3) {
			
			// Base case - simply draw a triangle using the three points
			// passed in
			if (order == 0) {
				// Draw a triangle to connect three points
				Polygon triangle = new Polygon();
				triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), 
											p2.getY(), p3.getX(), p3.getY());
				triangle.setStroke(Color.BLACK);
				triangle.setFill(Color.WHITE);

				this.getChildren().add(triangle);
			}// if
			
			// Otherwise, if order is not zero, reduce
			// the problem to drawing three Sierpinski
			// triangles of order -1
			else {
				// Get the midpoint on each edge in the triangle  
				Point2D p12 = p1.midpoint(p2);
				Point2D p23 = p2.midpoint(p3);
				Point2D p31 = p3.midpoint(p1);

				// Recursively display three triangles
				displayTriangles(order - 1, p1, p12, p31);
				displayTriangles(order - 1, p12, p2, p23);
				displayTriangles(order - 1, p31, p23, p3);
			}// else
		}// displayTriangles
	}// SierpinskiTrianglePane
  
	// The main method is only needed for the IDE with limited
	//JavaFX support. Not needed for running from the command line.	*/
	public static void main(String[] args) {
		launch(args);
	}//main
}//SierpinskiTriangle
