package helth2;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
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

public class CalculateFunktion {
	Stage window;
	Button button1;
	Button button2;
	boolean completed;
	public static String vysledek;

	public static void simpleCalculation(String title, String message) {

		Stage window = new Stage();
		window.setTitle("Výpočet kalorií");

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		String vysledek = (Double.toString(ButtonFunktion.weight / Math.pow(ButtonFunktion.high, 2)));
		
		Scene scene = new Scene(grid, 200, 100);
		window.setScene(scene);
		window.show();
	}

}
