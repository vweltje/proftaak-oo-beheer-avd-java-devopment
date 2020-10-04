package nl.avd.javadev.proftaak;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Shape  {

    private Stage window = new Stage();
    protected ShapeType type;
    protected String[] fields;
    private Map<String, String> properties;
    private Map<String, TextField> textFields = new HashMap<>();
    private Button saveButton = new Button("Save");
    private Button cancelButton = new Button("Cancel");

    protected void setProperties(Map<String, String> properties) {
        if (properties == null) {
            this.properties = new HashMap<>();
            this.showStage();
        } else {
            this.properties = properties;
        }
    }

    protected void showStage() {
        for (String field : this.fields) {
            textFields.put(field, new TextField());
        }

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(type.toString());
        window.setMinWidth(250);
        VBox layout = new VBox(16);

        saveButton.setOnAction(e -> this.saveAction());
        cancelButton.setOnAction(e -> this.cancelAction());

        textFields.forEach((key,value) -> {
            Label label = new Label(key);
            layout.getChildren().addAll(label, value);
        });
        layout.getChildren().addAll(saveButton,cancelButton);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    private void saveAction() {
        textFields.forEach((fieldName, field) -> {
            String input = field.getText();
            if (!input.equals("")) {
                properties.put(fieldName, input);
            }
        });
        window.close();
    }

    private void cancelAction() {
        window.close();
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public String toString() {
        String propertiesSting = properties.keySet().stream()
                .map(key -> key + ": " + properties.get(key))
                .collect(Collectors.joining(", ", "", ""));
        return this.type + " - " + propertiesSting;
    }
}