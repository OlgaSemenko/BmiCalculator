
	package helth2;

	import javafx.application.Application;
	import javafx.geometry.Insets;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.CheckBox;
	import javafx.scene.control.ChoiceBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.GridPane;
	import javafx.stage.Stage;

	public class Main extends Application {

		Stage window;
		Button button1;
		Button button2;
		boolean completed;

		public static void main(String[] args) {
			launch(args);
		}

		@Override
		public void start(Stage primaryStage) throws Exception {
			window = primaryStage;
			window.setTitle("Výpoèet kalorií");

			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10, 10, 10, 10));
			grid.setVgap(8);
			grid.setHgap(10);

			button1 = new Button("Jednoduchý výpoèet");
			GridPane.setConstraints(button1, 1, 1);
			button1.setOnAction(e -> {
				ButtonFunktion.simpleButton();
			});
			
			button2 = new Button("Podrobný výpoèet");
			GridPane.setConstraints(button2, 1, 2);
			button2.setOnAction(e -> {
				ButtonFunktion.involvedButton();
			});

			grid.getChildren().addAll(button1, button2);

			Scene scene = new Scene(grid, 200, 100);
			window.setScene(scene);
			window.show();
		}
		
	
	}

