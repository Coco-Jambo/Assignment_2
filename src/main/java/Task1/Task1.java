package Task1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Task1 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        ArrayList<User> userList = new ArrayList<User>();

        //Register Scene
        GridPane gridPaneRegister = new GridPane();
        gridPaneRegister.setStyle("-fx-background-color: #151C40");
        gridPaneRegister.setMinSize(500, 300);
        gridPaneRegister.setPadding(new Insets(10));
        gridPaneRegister.setVgap(5);
        gridPaneRegister.setHgap(5);

        Text username = new Text("Username: ");
        username.setStyle("-fx-fill: #A7ABBE");
        username.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 22));
        TextField textField1 = new TextField();

        Text password = new Text("Password: ");
        password.setStyle("-fx-fill: #A7ABBE");
        password.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 22));
        TextField textField2 = new TextField();

        Button register = new Button("Register");
        Button alreadyUser = new Button("Already a user?");

        Label registerInfo = new Label();
        registerInfo.setPrefSize(300, 50);
        registerInfo.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 16));


        gridPaneRegister.setAlignment(Pos.CENTER);

        gridPaneRegister.add(username, 0, 0);
        gridPaneRegister.add(textField1, 1, 0);
        gridPaneRegister.add(password, 0, 1);
        gridPaneRegister.add(textField2, 1, 1);
        gridPaneRegister.add(register, 1, 2);
        GridPane.setHalignment(register, HPos.CENTER);
        gridPaneRegister.add(registerInfo, 1, 3);
        registerInfo.setAlignment(Pos.CENTER);
        gridPaneRegister.add(alreadyUser, 1, 4);
        GridPane.setHalignment(alreadyUser, HPos.CENTER);


        //Login Scene
        GridPane gridPaneLogin = new GridPane();
        gridPaneLogin.setStyle("-fx-background-color: #4C0A19");
        gridPaneLogin.setMinSize(500, 300);
        gridPaneLogin.setPadding(new Insets(10, 10, 10, 10));
        gridPaneLogin.setVgap(5);
        gridPaneLogin.setHgap(5);

        Text username2 = new Text("Username: ");
        username2.setStyle("-fx-fill: #A7ABBE");
        username2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 22));
        TextField textField3 = new TextField();

        Text password2 = new Text("Password: ");
        password2.setStyle("-fx-fill: #A7ABBE");
        password2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 22));
        TextField textField4 = new TextField();

        Button login = new Button("Login");
        Button newAccount = new Button("Create a new account");

        Label loginInfo = new Label();
        loginInfo.setPrefSize(300, 50);
        loginInfo.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 16));

        gridPaneLogin.setAlignment(Pos.CENTER);

        gridPaneLogin.add(username2, 0, 0);
        gridPaneLogin.add(textField3, 1, 0);
        gridPaneLogin.add(password2, 0, 1);
        gridPaneLogin.add(textField4, 1, 1);
        gridPaneLogin.add(login, 1, 2);
        GridPane.setHalignment(login, HPos.CENTER);
        gridPaneLogin.add(loginInfo, 1, 3);
        loginInfo.setAlignment(Pos.CENTER);
        gridPaneLogin.add(newAccount, 1, 4);
        GridPane.setHalignment(newAccount, HPos.CENTER);


        Scene Registerscene = new Scene(gridPaneRegister);
        Scene Loginscene = new Scene(gridPaneLogin);


        //Button Events
        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (!textField1.getText().isEmpty() && !textField2.getText().isEmpty()) {
                    userList.add(new User(textField1.getText(), textField2.getText()));
                    registerInfo.setStyle("-fx-text-fill: #18CB18");
                    registerInfo.setText("Successfullly registered");


                } else {
                    registerInfo.setStyle("-fx-text-fill: #B7D6F0");
                    registerInfo.setText("Please enter a username/password");
                }
            }
        });

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (textField3.getText().isBlank() || textField4.getText().isBlank()) {
                    loginInfo.setStyle("-fx-text-fill: #B7D6F0");
                    loginInfo.setText("Please enter a username/password");

                } else {
                    if (!userList.isEmpty()) {
                        for (User u : userList) {
                            if (textField3.getText().equals(u.getUsername()) && textField4.getText().equals(u.getPassword())) {
                                loginInfo.setStyle("-fx-text-fill: #18CB18");
                                loginInfo.setText("Successfully logged in");
                                break;

                            } else {
                                loginInfo.setStyle("-fx-text-fill: #FA2D1C");
                                loginInfo.setText("Wrong username/password");
                            }
                        }
                    } else {
                        loginInfo.setStyle("-fx-text-fill: #FA2D1C");
                        loginInfo.setText("Wrong username/password");
                    }
                }
            }
        });

        alreadyUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(Loginscene);
                textField1.clear();
                textField2.clear();
                registerInfo.setText(null);
            }
        });

        newAccount.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(Registerscene);
                textField3.clear();
                textField4.clear();
                loginInfo.setText(null);
            }
        });

        primaryStage.setTitle("Assignment 2: Task 1");
        primaryStage.setScene(Registerscene);
        primaryStage.show();
    }
}