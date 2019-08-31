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

		Label weightLabel = new Label("V�ha:");
		GridPane.setConstraints(weightLabel, 0, 1);

		weightInput = new TextField("vaha");
		GridPane.setConstraints(weightInput, 1, 1);
		weightInput.textProperty().addListener((observable, oldValue, newValue) -> {
			weight = Float.parseFloat(newValue);
		});

		Label highLabel = new Label("V��ka:");
		GridPane.setConstraints(highLabel, 0, 2);

		highInput = new TextField("vyska");
		GridPane.setConstraints(highInput, 1, 2);
		highInput.textProperty().addListener((observable, oldValue, newValue) -> {
			high = Float.parseFloat(newValue);
		});

		button = new Button("Vypo�ti");
		GridPane.setConstraints(button, 1, 4);
		button.setOnAction(e -> {
			CalculateFunktion.simpleCalculation("V�sledek BMI", "Va�e BMI je: " + CalculateFunktion.vysledek);
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

		Label ageLabel = new Label("V�k:");
		GridPane.setConstraints(ageLabel, 0, 0);

		ageInput = new TextField("v�k");
		GridPane.setConstraints(ageInput, 1, 0);
		ageInput.textProperty().addListener((observable, oldValue, newValue) -> {
			if (isFloat(newValue)) {
				age = Float.parseFloat(newValue);
			}
		});

		Label weightLabel = new Label("V�ha:");
		GridPane.setConstraints(weightLabel, 0, 1);

		weightInput = new TextField("vaha");
		GridPane.setConstraints(weightInput, 1, 1);
		weightInput.textProperty().addListener((observable, oldValue, newValue) -> {
			weight = Float.parseFloat(newValue);
		});

		Label highLabel = new Label("V��ka:");
		GridPane.setConstraints(highLabel, 0, 2);

		highInput = new TextField("vyska");
		GridPane.setConstraints(highInput, 1, 2);
		highInput.textProperty().addListener((observable, oldValue, newValue) -> {
			high = Float.parseFloat(newValue);
		});

		button = new Button("Vypo�ti");
		GridPane.setConstraints(button, 1, 4);
		button.setOnAction(e -> {
			ButtonFunktion.simpleButton();
		});

		Label GenderLabel = new Label("Pohlav�:");
		GridPane.setConstraints(highLabel, 0, 2);

		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		GridPane.setConstraints(choiceBox, 0, 3);

		// getItems returns the ObservableList object which you can add items to
		choiceBox.getItems().add("Mu�");
		choiceBox.getItems().add("�ena");
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
		if (gender.equals("�ena")) {
			return "Po��t�me pro �enu";
		}
		if (gender.equals("Mu�")) {
			return "Po��t�me pro Mu�e";
		}
//		t�lesn� hmotnost v kg / t�lesn� v��ka v metrech na druhou.
		return Double.toString(weight / Math.pow(high, 2));
	}

	private static boolean isFloat(String newValue) {
// 		zkontorlovat jestli je to float, zkontrolovat 3 hodnoty-mus� b�t rozd�ln� od 0
// 		pokud ano nastavit buttonu-enabled true a vr�tit tu hodnotu
		return false;
	}

	private static void getChoice(ChoiceBox<String> choiceBox) {
		gender = choiceBox.getValue();
	}
}
