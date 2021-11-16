package Task5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

public class Task5 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(12));
        root.setStyle("-fx-background-color: #D32C19");

        HBox numbersPane = new HBox();
        numbersPane.setPadding(new Insets(12));
        numbersPane.setSpacing(10);

        Text nb1 = new Text("Number 1:");
        nb1.setStyle("-fx-fill: #FFFFFF");
        nb1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        TextField textField1 = new TextField();
        textField1.setPrefWidth(100);
        textField1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        textField1.setAlignment(Pos.CENTER);

        Text nb2 = new Text("Number 2:");
        nb2.setStyle("-fx-fill: #FFFFFF");
        nb2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        TextField textField2 = new TextField();
        textField2.setPrefWidth(100);
        textField2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        textField2.setAlignment(Pos.CENTER);

        Text result = new Text("Result:");
        result.setStyle("-fx-fill: #FFFFFF");
        result.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        TextField textField3 = new TextField();
        textField3.setEditable(false);
        textField3.setPrefWidth(100);
        textField3.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        textField3.setAlignment(Pos.CENTER);

        numbersPane.getChildren().addAll(nb1, textField1, nb2, textField2, result, textField3);
        numbersPane.setAlignment(Pos.CENTER);
        root.setCenter(numbersPane);

        HBox buttonPane = new HBox();
        buttonPane.setPadding(new Insets(0, 20, 10, 20));
        buttonPane.setSpacing(10);
        buttonPane.setPrefWidth(100);

        Button add = new Button("Add");
        add.setStyle("-fx-background-color: #184086; -fx-text-fill: #C5D0E4");
        add.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        Button substract = new Button("Substract");
        substract.setStyle("-fx-background-color: #184086; -fx-text-fill: #C5D0E4");
        substract.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        Button multiply = new Button("Multiply");
        multiply.setStyle("-fx-background-color: #184086; -fx-text-fill: #C5D0E4");
        multiply.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        Button divide = new Button("Divide");
        divide.setStyle("-fx-background-color: #184086; -fx-text-fill: #C5D0E4");
        divide.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));

        add.setMinWidth(buttonPane.getPrefWidth());
        substract.setMinWidth(buttonPane.getPrefWidth());
        multiply.setMinWidth(buttonPane.getPrefWidth());
        divide.setMinWidth(buttonPane.getPrefWidth());

        buttonPane.getChildren().addAll(add, substract, multiply, divide);
        buttonPane.setAlignment(Pos.CENTER);
        root.setBottom(buttonPane);

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String nb1 = textField1.getText();
                String nb2 = textField2.getText();
                DecimalFormat df = new DecimalFormat("#.##");
                Double result = Double.valueOf(df.format(Double.parseDouble(nb1) + Double.parseDouble(nb2)));
                textField3.setText(Double.toString(result));
            }
        });

        substract.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String nb1 = textField1.getText();
                String nb2 = textField2.getText();
                DecimalFormat df = new DecimalFormat("#.##");
                Double result = Double.valueOf(df.format(Double.parseDouble(nb1) - Double.parseDouble(nb2)));
                textField3.setText(Double.toString(result));
            }
        });

        multiply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String nb1 = textField1.getText();
                String nb2 = textField2.getText();
                DecimalFormat df = new DecimalFormat("#.##");
                Double result = Double.valueOf(df.format(Double.parseDouble(nb1) * Double.parseDouble(nb2)));
                textField3.setText(Double.toString(result));
            }
        });

        divide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String nb1 = textField1.getText();
                String nb2 = textField2.getText();
                DecimalFormat df = new DecimalFormat("#.##");
                Double result = Double.valueOf(df.format(Double.parseDouble(nb1) / Double.parseDouble(nb2)));
                textField3.setText(Double.toString(result));
            }
        });

        Scene scene = new Scene(root, 650, 250);
        primaryStage.setTitle("Assignment 2: Task 5");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
