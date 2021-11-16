package Task4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Task4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();

        Image ball = new Image("https://www.pngall.com/wp-content/uploads/5/Sports-Ball-Transparent.png");
        ImageView ballImageView = new ImageView(ball);
        ballImageView.setFitHeight(200);
        ballImageView.setFitWidth(210);
        ballImageView.setX(300);
        ballImageView.setY(200);


        Label l = new Label("UP: U\nDOWN: D\nLEFT: L\nRIGHT: R");
        l.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 22));
        l.relocate(12,460);

        root.getChildren().addAll(ballImageView,l);

        ballImageView.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent e) {

                switch (e.getCode()) {

                    case D:
                        ballImageView.setY(ballImageView.getY() + 20);
                        break;

                    case U:
                        ballImageView.setY(ballImageView.getY() - 20);
                        break;

                    case L:
                        ballImageView.setX(ballImageView.getX() - 20);
                        break;

                    case R:
                        ballImageView.setX(ballImageView.getX() + 20);
                        break;

                }
            }
        });

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Assignment 2: Task 4");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setResizable(false);
        ballImageView.requestFocus();

    }

}