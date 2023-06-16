import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BMICalculator extends Application {

    private TableView<BMIResult> tableView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("BMI Calculator");

        Label weightLabel = new Label("Weight (kg):");
        TextField weightField = new TextField();
        Label heightLabel = new Label("Height (cm):");
        TextField heightField = new TextField();
        Button calculateButton = new Button("Calculate BMI");

        calculateButton.setOnAction(e -> calculateBMI(weightField, heightField));

        tableView = new TableView<>();
        TableColumn<BMIResult, String> rangeColumn = new TableColumn<>("BMI Range");
        rangeColumn.setCellValueFactory(new PropertyValueFactory<>("range"));
        TableColumn<BMIResult, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        tableView.getColumns().addAll(rangeColumn, categoryColumn);

        VBox vbox = new VBox(10, weightLabel, weightField, heightLabel, heightField, calculateButton, tableView);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateBMI(TextField weightField, TextField heightField) {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText()) / 100; // Convert cm to meters

            double bmi = weight / (height * height);

            tableView.getItems().forEach(item -> item.setHighlighted(false));
            tableView.getItems().stream()
                    .filter(result -> bmi >= result.getRangeStart() && bmi < result.getRangeEnd())
                    .findFirst()
                    .ifPresent(result -> result.setHighlighted(true));
        } catch (NumberFormatException e) {
 
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Please enter valid numeric values for weight and height.");
            alert.showAndWait();
        }
    }

    private static class BMIResult {
        private String range;
        private String category;
        private double rangeStart;
        private double rangeEnd;
        private boolean highlighted;

        public BMIResult(String range, String category, double rangeStart, double rangeEnd) {
            this.range = range;
            this.category = category;
            this.rangeStart = rangeStart;
            this.rangeEnd = rangeEnd;
        }

        public String getRange() {
            return range;
        }

        public String getCategory() {
            return category;
        }

        public double getRangeStart() {
            return rangeStart;
        }

        public double getRangeEnd() {
            return rangeEnd;
        }

        public boolean isHighlighted() {
            return highlighted;
        }

        public void setHighlighted(boolean highlighted) {
            this.highlighted = highlighted;
        }
    }
}
