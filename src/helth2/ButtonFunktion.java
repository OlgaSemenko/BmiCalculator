package helth2;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import helth2.ButtonFunktion;
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

public class ButtonFunktion {
	Stage window;
	public static float weight;
	public static float high;
	static float age;
	static String gender;

	public static void simpleButton() {
		TextField weightInput;
		TextField highInput;
		Button button;
		boolean completed;

		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(250);
		Label label = new Label();

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		Label weightLabel = new Label("Váha:");
		GridPane.setConstraints(weightLabel, 0, 1);

		weightInput = new TextField("vaha");
		GridPane.setConstraints(weightInput, 1, 1);
		weightInput.textProperty().addListener((observable, oldValue, newValue) -> {
			weight = Float.parseFloat(newValue);
		});

		Label highLabel = new Label("Výška:");
		GridPane.setConstraints(highLabel, 0, 2);

		highInput = new TextField("vyska");
		GridPane.setConstraints(highInput, 1, 2);
		highInput.textProperty().addListener((observable, oldValue, newValue) -> {
			high = Float.parseFloat(newValue);
		});

		button = new Button("Vypoèti");
		GridPane.setConstraints(button, 1, 4);
		button.setOnAction(e -> {
			CalculateFunktion.simpleCalculation("Výsledek BMI", "Vaše BMI je: " + CalculateFunktion.vysledek);
		});

		grid.getChildren().addAll(weightLabel, weightInput, highLabel, highInput, button);

		Scene scene = new Scene(grid, 300, 200);
		window.setScene(scene);
		window.show();

	}

	public static void involvedButton() {
		Stage window;
		Button button;
		TextField ageInput;
		TextField weightInput;
		TextField highInput;
		boolean completed;

		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(250);
		Label label = new Label();

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		Label ageLabel = new Label("Vìk:");
		GridPane.setConstraints(ageLabel, 0, 0);

		ageInput = new TextField("vìk");
		GridPane.setConstraints(ageInput, 1, 0);
		ageInput.textProperty().addListener((observable, oldValue, newValue) -> {
			if (isFloat(newValue)) {
				age = Float.parseFloat(newValue);
			}
		});

		Label weightLabel = new Label("Váha:");
		GridPane.setConstraints(weightLabel, 0, 1);

		weightInput = new TextField("vaha");
		GridPane.setConstraints(weightInput, 1, 1);
		weightInput.textProperty().addListener((observable, oldValue, newValue) -> {
			weight = Float.parseFloat(newValue);
		});

		Label highLabel = new Label("Výška:");
		GridPane.setConstraints(highLabel, 0, 2);

		highInput = new TextField("vyska");
		GridPane.setConstraints(highInput, 1, 2);
		highInput.textProperty().addListener((observable, oldValue, newValue) -> {
			high = Float.parseFloat(newValue);
		});

		button = new Button("Vypoèti");
		GridPane.setConstraints(button, 1, 4);
		button.setOnAction(e -> {
			ButtonFunktion.simpleButton();
		});

		Label GenderLabel = new Label("Pohlaví:");
		GridPane.setConstraints(highLabel, 0, 2);

		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		GridPane.setConstraints(choiceBox, 0, 3);

		// getItems returns the ObservableList object which you can add items to
		choiceBox.getItems().add("Muž");
		choiceBox.getItems().add("Žena");
		choiceBox.getItems().add("");

		// Set a default value
		choiceBox.setValue("");

		choiceBox.setOnAction(e -> getChoice(choiceBox));

		grid.getChildren().addAll(ageLabel, ageInput, weightLabel, weightInput, highLabel, highInput, button,
				choiceBox);

		Scene scene = new Scene(grid, 300, 200);
		window.setScene(scene);
		window.show();

	}

	private String calculateBmi() {
		if (gender.equals("Žena")) {
			return "Poèítáme pro Ženu";
		}
		if (gender.equals("Muž")) {
			return "Poèítáme pro Muže";
		}
//		tìlesná hmotnost v kg / tìlesná výška v metrech na druhou.
		return Double.toString(weight / Math.pow(high, 2));
	}

	private static boolean isFloat(String newValue) {
// 		zkontorlovat jestli je to float, zkontrolovat 3 hodnoty-musí být rozdílné od 0
// 		pokud ano nastavit buttonu-enabled true a vrátit tu hodnotu
		return false;
	}

	private static void getChoice(ChoiceBox<String> choiceBox) {
		gender = choiceBox.getValue();
	}
}
