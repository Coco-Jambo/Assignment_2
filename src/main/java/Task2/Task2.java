package Task2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Task2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {

        //Creating the BorderPane
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(12));

        //Creating a custom Pane for light bulb images
        class BulbPane extends StackPane {

            Image bulbOn = new Image("file: src/images/on.png");
            ImageView bulbOnImageView = new ImageView(bulbOn);

            Image bulbOff = new Image("file:src/images/off.png");
            ImageView bulbOffImageView = new ImageView(bulbOff);

            public BulbPane() {
                bulbOnImageView.setFitHeight(300);
                bulbOnImageView.setFitWidth(300);

                bulbOffImageView.setFitHeight(300);
                bulbOffImageView.setFitWidth(300);

                getChildren().add(bulbOffImageView);
                getChildren().add(bulbOnImageView);

                bulbOnImageView.setVisible(false);
            }

            public void on() {
                bulbOnImageView.setVisible(true);
            }

            public void off() {
                bulbOnImageView.setVisible(false);
            }

        }

        BulbPane bulbPane = new BulbPane();

        //Creating HBox for buttons
        HBox buttonPane = new HBox(25);

        Button btOn = new Button("ON");
        btOn.setPrefSize(100, 50);
        btOn.setStyle("-fx-background-color: #F6C924;  -fx-font-size: 32");

        Button btOff = new Button("OFF");
        btOff.setPrefSize(100, 50);
        btOff.setStyle("-fx-background-color: #353226; -fx-font-size: 32; -fx-text-fill: #EDE9DB");

        buttonPane.getChildren().addAll(btOn, btOff);
        buttonPane.setAlignment(Pos.CENTER);

        root.setCenter(bulbPane);
        root.setBottom(buttonPane);


        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Assignment 2: Task 2");
        primaryStage.setScene(scene);
        primaryStage.show();

        bulbPane.requestFocus();

        //Button Events
        btOn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                bulbPane.on();
            }
        });

        btOff.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                bulbPane.off();
            }
        });
    }

}