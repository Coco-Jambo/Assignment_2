package Task3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Task3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(20);

        TextField txt = new TextField();
        txt.setText("0");
        txt.setPrefWidth(300);
        txt.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        txt.setAlignment(Pos.CENTER);

        HBox buttonPane = new HBox(25);

        Button btIncrement = new Button("INCREMENT");
        btIncrement.setPrefSize(200, 20);
        btIncrement.setStyle("-fx-background-color: #BB2611;  -fx-font-size: 2em; -fx-text-fill: #EDE9DB");

        Button btDecrement = new Button("DECREMENT");
        btDecrement.setPrefSize(200, 20);
        btDecrement.setStyle("-fx-background-color: #160BC1; -fx-font-size: 2em; -fx-text-fill: #EDE9DB");

        buttonPane.getChildren().addAll(btIncrement, btDecrement);
        buttonPane.setAlignment(Pos.CENTER);

        root.add(txt,0,0);
        root.add(buttonPane,0,1);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Assignment 2: Task 3");
        primaryStage.setScene(scene);
        primaryStage.show();


        btIncrement.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String counter = txt.getText();
                txt.setText(Integer.toString(Integer.parseInt(counter) + 1));
            }
        });

        btDecrement.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String counter = txt.getText();
                txt.setText(Integer.toString(Integer.parseInt(counter) - 1));
            }
        });
    }

}